package com.example.EmployeeService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeService.Entity.Employee;
import com.example.EmployeeService.repository.EmployeRepository;


/**
 * 
 * @author Chandeshwar Thakur
 * @version 1.0
 * Controller layer
 */
@RestController
public class EmployeeController {

	static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeRepository empRepository;
	
	/**
	 * @author chathaku1
	 * @apiNote Method saveInformation
	 * @param employee Obj
	 * @return String
	 */
	@PostMapping("v1/saveInformation")
	public String saveInformation(@RequestBody Employee employee)
	{
		logger.info("EmployeeController saveInformation Method Started:");
		Employee employeObj=empRepository.save(employee);
		if(employeObj.getId()!=0)
		{
			logger.info("EmployeeController saveInformation Method:employeObj.getId()"+employeObj.getId());
			return "Success :";
		}
		logger.info("EmployeeController saveInformation Method:get failed while saving data:"+employeObj.getId());
		return "Failed";
	}
}
