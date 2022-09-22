package com.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.jpa.entity.Course;
import com.data.jpa.entity.Teacher;
import com.data.jpa.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	TeacherRepository teacherRepository;

	@Test
	public void saveTeacher() {

		Course course = Course.builder()
				.title("Chemistry")
				.credit(10)
				.build();

		Teacher teacher = Teacher.builder()
				.firstname("Kanti")
				.lastname("Madam")
				.courses(List.of(course))
				.build();
		
		teacherRepository.save(teacher);
		
	}

}
