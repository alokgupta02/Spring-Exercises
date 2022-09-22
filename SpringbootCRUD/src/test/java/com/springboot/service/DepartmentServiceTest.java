package com.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.entity.Department;
import com.springboot.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.departmentName("IT")
				.departmentAddress("Noida")
				.departmentCode("NO-98")
				.build();

		Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("Valid Department Name Test")
	void testFetchDepartmentByName() {
		String departmentName = "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);

		assertEquals(departmentName, found.getDepartmentName());
		//fail("Not yet implemented");
	}

}
