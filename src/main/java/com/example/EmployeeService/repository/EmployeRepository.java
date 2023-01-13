package com.example.EmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeService.Entity.Employee;

/**
 * 
 * @author Chandeshwar Thakur
 * @version 1.0
 * Persistence Layer
 */

@Repository
public interface EmployeRepository extends JpaRepository<Employee, Integer>{

}
