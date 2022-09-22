package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	
	// Save operation
	void saveEmployee(Employee employee);

	// Read operation
	List<Employee> getAllEmployees();
	
	// Update operation
	Employee getEmployeeById(long id);
	
	// Delete operation
	void deleteEmployeeById(long id);

}
