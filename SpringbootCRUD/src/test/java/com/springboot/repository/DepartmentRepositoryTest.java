package com.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springboot.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder()
				.departmentName("IT")
				.departmentAddress("Mumbai")
				.departmentCode("IT-06")
				.build();
		
		entityManager.persist(department);
		
	}

	@Test
	void testFindByDepartmentName() {
		String departmentName = "IT";
		Department department = departmentRepository.findByDepartmentName(departmentName);
		assertEquals(department.getDepartmentName(), "IT");
		
	}

}
