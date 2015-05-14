package com.cognizant.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.beans.Employee;
import com.cognizant.services.EmployeeService;

/**
 * Controller
 * 
 * @author CHAPPIE
 *
 */
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService; // instance of service class
	static List<Map<String, String>> ldetails = new ArrayList<Map<String, String>>();

	@RequestMapping("/")
	public ModelAndView welcome() {
		ldetails = employeeService.loadDeatils();
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.getModel().put("deptlist", ldetails.get(0));
		modelAndview.getModel().put("techlist", ldetails.get(1));
		modelAndview.getModel().put("managerlist", ldetails.get(2));
		modelAndview.setViewName("index");
		return modelAndview;
	}

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.getModel().put("deptlist", ldetails.get(0));
		modelAndview.getModel().put("techlist", ldetails.get(1));
		modelAndview.getModel().put("managerlist", ldetails.get(2));
		modelAndview.setViewName("index");
		return modelAndview;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(Employee e) {

		List<Employee> list = new ArrayList<Employee>();

		list = employeeService.SearchService(e, "home"); // calling
															// service
															// method
		if (list.isEmpty()) {
			return new ModelAndView("noresult"); // checking whether search
													// result is null or not
		} else {
			return new ModelAndView("searchresult", "lists", list); // returning
																	// model and
																	// view
																	// object
		}
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("id") String id) { // method to view
																// employee
		Employee e = new Employee();
		e.setEmployeeId(id);
		List<Employee> elist = employeeService.SearchService(e, "view");

		return new ModelAndView("view", "lists", elist);
	}

	@RequestMapping(value = "/editact", method = RequestMethod.POST)
	// method to edit the employee details
	public ModelAndView updateEmpdeatils(Employee e,
			@RequestParam("oldeid") String oldeid) {
		List<Employee> list = new ArrayList<Employee>();
		e.setOldEid(oldeid);
		employeeService.upDetailservice(e, "update");
		Employee es = new Employee();
		es.setEmployeeId(e.getEmployeeId());
		list = employeeService.SearchService(es, "update");
		return new ModelAndView("editsucess", "lists", list);

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	// method to get the employee details and get the technology department
	// related info
	public ModelAndView edit(@RequestParam("id") String id) {
		Employee e = new Employee();
		e.setEmployeeId(id);
		List<Employee> elist = employeeService.SearchService(e, "edit");
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.getModel().put("EmpId", id);
		modelAndview.getModel().put("deptlist", ldetails.get(0));
		modelAndview.getModel().put("techlist", ldetails.get(1));
		modelAndview.getModel().put("managerlist", ldetails.get(2));
		modelAndview.getModel().put("elist", elist);
		modelAndview.setViewName("editdetails");
		return modelAndview;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	// method to delete the employee
	public ModelAndView delete(@RequestParam("id") String id) {
		employeeService.deleteService(id);
		return new ModelAndView("cnfdelete");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	// method to load details before adding employee
	public ModelAndView addAction() {
		List<Map<String, String>> ldetails = employeeService.loadDeatils();

		return new ModelAndView("add", "lists", ldetails);
	}

	@RequestMapping(value = "/addact", method = RequestMethod.POST)
	public ModelAndView addcnf(Employee e) {
		Boolean status = employeeService.upDetailservice(e, "edit");
		if (status == true) {
			return new ModelAndView("add2");
		} else {
			return new ModelAndView("addsuccess");
		}

	}

}
