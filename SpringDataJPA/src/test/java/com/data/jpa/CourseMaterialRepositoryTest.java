package com.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.jpa.entity.Course;
import com.data.jpa.entity.CourseMaterial;
import com.data.jpa.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	//@Test
	public void saveCourseMaterial() {
		Course course = Course.builder()
				.credit(10)
				.title("Physics")
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.google.com")
				.course(course)
				.build();
		
		courseMaterialRepository.save(courseMaterial);
		
	}
	
	@Test
	public void printAllCourseMaterial() {
		List <CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
		System.out.println(courseMaterialList);
	}

}
