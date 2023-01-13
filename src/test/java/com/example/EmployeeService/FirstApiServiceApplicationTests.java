package com.example.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.EmployeeService.Entity.Employee;
import com.example.EmployeeService.repository.EmployeRepository;
import com.example.EmployeeService.service.EmployeeService;

//@RunWith(SpringRunner.class)
@SpringBootTest
class FirstApiServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired 
	private EmployeeService employeeService;

	@MockBean
	private EmployeRepository employeRepository;

	@Test
	public void getEmployeeTest() { 
		Mockito.when(employeRepository.findAll()).thenReturn(Stream
				.of(new Employee(1, "chandeshwar", "IT", 300000)).collect(Collectors.toList()));
		assertEquals(1, employeeService.getEmployess().size());
	}

	@Test
	public void saveUserTest() {
		Employee employee = new Employee("Pranya","Thakur", 1100);
		Mockito.when(employeRepository.save(employee)).thenReturn(employee);
		String msg=employeeService.saveData(employee);
		
		assertEquals("Failed", msg);
	}

	
}
