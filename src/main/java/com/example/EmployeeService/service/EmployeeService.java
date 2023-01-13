package com.example.EmployeeService.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeService.Entity.Employee;
import com.example.EmployeeService.repository.EmployeRepository;

/**
 * 
 * @author Chandeshwar Thakur
 * @version 1.0 Service layer
 */
@Service
public class EmployeeService {

	//static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeRepository employeRepository;

	/**
	 * @author Chandeshwar Thakur
	 * @apiNote Method saveData
	 * @param employee Obj
	 * @return String
	 */
	public String saveData(Employee employee) {
		Employee employeObj = employeRepository.save(employee);
		if (employeObj.getId() != 0) {
			//	 logger.info("EmployeeService saveData Method:employeObj.getId()"+employeObj.getId());
			return "Success:";
		}
		// logger.info("EmployeeService saveInformation Method:get failed while saving data:"+employeObj.getId());
		return "Failed";
	}

	/**
	 * @author Chandeshwar Thakur
	 * @apiNote Method getEmployess
	 * @param employee Obj
	 * @return List<Employee>
	 */
	public List<Employee> getEmployess() {
		//logger.info("EmployeeService getEmployess Method Started:");
		List<Employee> employeObj = employeRepository.findAll();
		if (!employeObj.isEmpty()) {
			// logger.info("EmployeeService getEmployess Method:employeObj.getId()"+employeObj);
			return employeObj;
		}
		// logger.info("EmployeeService getEmployess Method:get failed while saving data:"+employeObj);
		return new ArrayList<>();
	}
}
