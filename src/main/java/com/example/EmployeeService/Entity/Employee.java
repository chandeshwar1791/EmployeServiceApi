package com.example.EmployeeService.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Chandeshwar Thakur
 * @version 1.0
 * Entity Class
 */

@Entity
@Table
@Data

public class Employee {
    @Id
    @GeneratedValue
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dept")
    private String dept;
    @JsonProperty("salary")
    private long salary;
    
    public Employee() {
		
	}
    
	public Employee(int id,String name, String dept, long salary) {
		super();
		this.id=id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public Employee(String name, String dept, long salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
    
    
}
