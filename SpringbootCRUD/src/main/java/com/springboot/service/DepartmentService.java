package com.springboot.service;

import java.util.List;

import com.springboot.entity.Department;
import com.springboot.exception.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(int departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(int departmentId);

	public Department updateDepartment(int departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
