package com.example.coding.demo;

import com.example.coding.demo.model.Employee;
import com.example.coding.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Date;

@SpringBootApplication
@EnableCaching
public class CodingDemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(CodingDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setName("demo");
		employee.setEmail("test@test.com");
		employee.setJoiningDate(new Date());
		employee.setSalary(1500);
		employee.setRole("Lead");
		this.employeeService.saveEmployee(employee);
	}
}
