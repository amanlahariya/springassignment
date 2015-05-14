package com.cognizant.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.beans.Employee;
import com.cognizant.dao.EmployeeDao;
import com.cognizant.interfaces.EmployeedaoInterface;

@Service
public class EmployeeService {
	private EmployeedaoInterface employeeDao;
	static List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	
	public List<Employee> SearchService(Employee e, String call) { // method to search for employee based on
			Map<String, String> searchBy=new HashMap<String, String>();// category
			int count=0;
			if(call.equals("home")){
			
		if(!(e.getEmployeeId().equals(""))){
			searchBy.put("e1.employee_id", e.getEmployeeId());
			count++;
		}
		if(!(e.getEmployeeName().equals(""))){
			searchBy.put("e1.employee_name", e.getEmployeeName());
			count++;
		}
		if(!(e.getDepartment().equals(""))){
			searchBy.put("d.department_name", e.getDepartment());
			count++;
		}
		if((!e.getTechnology().equals(""))){
			searchBy.put("t.technology_name", e.getTechnology());
			count++;
		}
		if((!e.getManager().equals(""))){
			searchBy.put("e2.employee_name", e.getManager());
			count++;
		}
		}
       else{
    	   searchBy.put("e1.employee_id", e.getEmployeeId());
    	   count++;
			}
			if(count==0){
				return new ArrayList<Employee>();
			}
		else{
		return employeeDao.searchEmployee(searchBy);
			}
			
	}
	

	public List<Map<String, String>> loadDeatils() { // method to load details
		list.add(employeeDao.getDeptlist()); // get and add department map
												// having key as id and
												// department name as value
		list.add(employeeDao.getTechnologylist()); // get and add Technology map
													// having key as id and
													// technology name as value
		list.add(employeeDao.getManagerlist()); // get and add manager map
												// having key as id and manager
												// name as value
		list.add(employeeDao.getProjectlist()); // get and add project map
												// having key as id and project
												// name as value
		return list;
	}

	public Boolean upDetailservice(Employee e, String mod) {
		int i;
		Map<String, String> dmap = new HashMap<String, String>();
		for (i = 0; i < 3; i++) {
			dmap = (Map<String, String>) list.get(i);
			for (Map.Entry entry : dmap.entrySet()) { // finding and setting the
														// id's from value from
														// map
				if (e.getDepartment().equals(entry.getValue())) {
					e.setDeptId((String) entry.getKey());

				} else if (e.getTechnology().equals(entry.getValue())) {
					e.setTechId((String) entry.getKey());
				} else if (e.getManager().equals(entry.getValue())) {
					e.setManagerId((String) entry.getKey());
				}

			}

		}
		if (mod.equals("update")) {
			employeeDao.upDetaildao(e); // detecting whether it is a call from
										// update or insert
			return true;
		} else {
			if (employeeDao.searchId(e.getEmployeeId())) {
				return true;
			} else {
				dmap = (Map<String, String>) list.get(i);
				for (Map.Entry entry : dmap.entrySet()) { // finding and setting
															// the id from value
															// from map
					if (e.getProject().equals(entry.getValue())) {
						e.setProjectId((String) entry.getKey());
					}
				}
				employeeDao.addDetaildao(e); // insert new employee
				return false;
			}
		}

	}

	public void deleteService(String id) {
		employeeDao.empdeleteDao(id); // delete employee

	}

}
