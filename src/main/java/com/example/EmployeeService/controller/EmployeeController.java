package com.example.EmployeeService.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeService.Entity.Employee;
import com.example.EmployeeService.repository.EmployeRepository;
import com.example.EmployeeService.service.EmployeeService;


/**
 * 
 * @author Chandeshwar Thakur
 * @version 1.0
 * Controller layer
 */
@RestController
public class EmployeeController {

	//static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * @author Chandeshwar Thakur
	 * @apiNote Method saveInformation
	 * @param employee Obj
	 * @return String
	 */
	@PostMapping("v1/saveInformation")
	public String saveInformation(@RequestBody Employee employee)
	{
		//logger.info("EmployeeController saveInformation Method Started:");
		String msg=employeeService.saveData(employee);
		//logger.info("EmployeeController saveInformation Method:get failed while saving data:msg:"+msg);
		return msg;
	}
	
	/**
	 * @author Chandeshwar Thakur
	 * @apiNote Method getEmployess
	 * @param employee Obj
	 * @return String
	 */
	@GetMapping("v1/employees")
	public List<Employee> getEmployess()
	{
		//logger.info("EmployeeController getEmployess Method Started:");
		
		return employeeService.getEmployess();
	}
}
