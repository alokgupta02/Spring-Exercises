package com.springboot.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.entity.Department;
import com.springboot.exception.DepartmentNotFoundException;
import com.springboot.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		log.info("inside save department method");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/getDepartment")
	public List<Department> fetchDepartment(){
		log.info("inside get department method");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/getDepartment/{id}")
	public Department fetchDepartmentById(@PathVariable("id") int departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@GetMapping("department/{departmentName}")
	public Department fetchDepartmentByName(@PathVariable("departmentName") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDepartmentById(@PathVariable("id") int departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department Deleted successfully";
	}
	
	@PutMapping("/update/{id}")
	public Department updateDepartment(@PathVariable("id") int departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
		
	}

}