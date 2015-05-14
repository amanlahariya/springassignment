package com.cognizant.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.beans.Employee;

public interface EmployeedaoInterface {
	public List<Employee> searchEmployee(Map<String, String> searchBy);
	public void upDetaildao(Employee e);
	public void empdeleteDao(String id) ;
	public boolean searchId(String id);
	public void addDetaildao(Employee e);
	public Map<String, String> getDeptlist();
	public Map<String, String> getTechnologylist();
	public Map<String, String> getManagerlist();
	public Map<String, String> getProjectlist();

}
