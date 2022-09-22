package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// display list of Employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
		
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@PostMapping("/update/{id}")
	public String updateEmployee(@PathVariable("id") long id, Employee employee, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	employee.setId(id);
	        return "update_employee";
	    }
	        
	    employeeService.saveEmployee(employee);
	    return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable ("id") long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
}
