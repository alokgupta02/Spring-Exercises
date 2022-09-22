package com.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot.entity.Department;
import com.springboot.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService departmentService;

	private Department department;

	@BeforeEach
	void setUp() throws Exception {

		department = Department.builder().departmentAddress("Delhi").departmentCode("DDC-06").departmentName("IT-DDC")
				.departmentId(2).build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inputDepartment = Department.builder().departmentAddress("Delhi").departmentCode("DDC-06")
				.departmentName("IT-DDC").build();

		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

		mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "		\"departmentName\": \"IT-DDC\",\r\n"
						+ "		\"departmentAddress\": \"Delhi\",\r\n" + "		\"departmentCode\": \"DDC-06\"\r\n"
						+ "}"))
				.andExpect(status().isOk());

	}

	@Test
	void testFetchDepartmentById() throws Exception {
		Mockito.when(departmentService.fetchDepartmentById(2)).thenReturn(department);

		mockMvc.perform(get("/getDepartment/2")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.departmentName")
				.value(department.getDepartmentName()));

	}

}
