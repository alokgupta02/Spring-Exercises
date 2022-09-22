package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>
{

	public Department findByDepartmentName(String departmentName);
}
