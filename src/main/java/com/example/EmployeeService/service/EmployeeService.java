package com.example.EmployeeService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EmployeeService.Entity.Employee;

public interface EmployeeService {

	public String saveData(Employee employee);

	public List<Employee> getEmployess();
}
