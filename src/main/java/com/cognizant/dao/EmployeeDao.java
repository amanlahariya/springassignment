package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cognizant.beans.Employee;
import com.cognizant.interfaces.EmployeedaoInterface;

@Repository("employeeDao")
public class EmployeeDao  implements EmployeedaoInterface{
	
	private JdbcTemplate jdbcTemplate;
private int a;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Employee> searchEmployee(Map<String, String> searchby) { // search the employee
		StringBuffer str=new StringBuffer();
		
		for (Map.Entry entry : searchby.entrySet()) {
			str.append((String) entry.getKey()+" like "+"'%"+entry.getValue()+"%'"+" and ");
			}
		int i=str.lastIndexOf(" and ");
		str.delete(i, str.length());
		String sql = "SELECT e1.employee_id,e1.employee_name,d.department_name,t.technology_name,e2.employee_name as manager_name"
				+ " FROM employee e1 join department d on e1.department_id=d.department_id join technology t on e1.technology_id=t.technology_id"
				+ " left outer join employee e2 on e2.employee_id=e1.manager_id where "+str;
		return jdbcTemplate.query(sql,
				new ResultSetExtractor<List<Employee>>() {
					public List<Employee> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Employee> list = new ArrayList<Employee>();
						while (rs.next()) {
							Employee e = new Employee();
							e.setEmployeeId(rs.getString(1));
							e.setEmployeeName(rs.getString(2));
							e.setDepartment(rs.getString(3));
							e.setTechnology(rs.getString(4));
							e.setManager(rs.getString(5));
							list.add(e); // setting the values in bean and
											// finally adding it to list
						}

						return list;
					}
				});
	}

	public Map<String, String> getDeptlist() { // getting the id and name and
												// put it in hash map

		String sql = "select * from department";

		return jdbcTemplate.query(sql,
				new ResultSetExtractor<Map<String, String>>() {

					public Map<String, String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Map<String, String> deptmap = new HashMap<String, String>();

						while (rs.next()) {
							deptmap.put(rs.getString(1), rs.getString(2));

						}
						// TODO Auto-generated method stub
						return deptmap;
					}
				});
	}

	public Map<String, String> getTechnologylist() { // getting the id and name
														// and put it in hash
														// map

		String sql = "select * from technology";

		return jdbcTemplate.query(sql,
				new ResultSetExtractor<Map<String, String>>() {

					public Map<String, String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Map<String, String> techmap = new HashMap<String, String>();

						while (rs.next()) {
							techmap.put(rs.getString(1), rs.getString(2));

						}
						// TODO Auto-generated method stub
						return techmap;
					}
				});
	}

	public Map<String, String> getManagerlist() { // getting the id and name and
													// put it in hash map

		String sql = "SELECT e2.manager_id,e1.employee_name FROM employee e1 join employee e2 on e1.employee_id=e2.manager_id";

		return jdbcTemplate.query(sql,
				new ResultSetExtractor<Map<String, String>>() {

					public Map<String, String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Map<String, String> managerMap = new HashMap<String, String>();

						while (rs.next()) {
							managerMap.put(rs.getString(1), rs.getString(2));

						}
						// TODO Auto-generated method stub
						return managerMap;
					}
				});
	}

	public Map<String, String> getProjectlist() { // getting the id and name and
													// put it in hash map
		String sql = "select * from projects";

		return jdbcTemplate.query(sql,
				new ResultSetExtractor<Map<String, String>>() {

					public Map<String, String> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Map<String, String> projectmap = new HashMap<String, String>();

						while (rs.next()) {
							projectmap.put(rs.getString(1), rs.getString(2));

						}
						// TODO Auto-generated method stub
						return projectmap;
					}
				});

	}

	public void upDetaildao(Employee e) { // updating employee details
		String query = "update employee set employee_id=" + e.getEmployeeId()
				+ ",employee_name='" + e.getEmployeeName() + "',department_id="
				+ e.getDeptId() + ",manager_id=" + e.getManagerId()
				+ ",technology_id=" + e.getTechId() + " where employee_id="
				+ e.getOldEid();
		jdbcTemplate.update(query);

	}

	public void empdeleteDao(String id) { // deleting employee details
		String query = "delete from employee where employee_id=" + id;
		jdbcTemplate.update(query);

	}

	public boolean searchId(String id) { // finding whether on adding employee
											// id,employee id is present or not
		String sql = "select employee_id from employee where employee_id=" + id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				

				if (rs.next()) {
					return true;

				} else {
					return false;
				}
			}
		});
	}

	public void addDetaildao(Employee e) { // adding employee details
		String query = "insert into employee values(" + e.getEmployeeId()
				+ ",'" + e.getEmployeeName() + "',now()," + e.getDeptId() + ","
				+ e.getManagerId() + "," + e.getProjectId() + ","
				+ e.getTechId() + ")";
		jdbcTemplate.update(query);

	}

}
