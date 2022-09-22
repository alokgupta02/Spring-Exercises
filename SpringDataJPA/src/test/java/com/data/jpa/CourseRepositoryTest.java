package com.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.data.jpa.entity.Course;
import com.data.jpa.entity.Parent;
import com.data.jpa.entity.Student;
import com.data.jpa.entity.Teacher;
import com.data.jpa.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	// @Test
	public void printAllCourses() {
		List<Course> courseList = courseRepository.findAll();
		System.out.println(courseList);

	}

	// @Test
	public void saveCourseWithTeacher() {

		Teacher teacher = Teacher.builder().firstname("Hashmi").lastname("Sir").build();

		Course course = Course.builder().credit(10).title("Mathematics").teacher(teacher).build();

		courseRepository.save(course);

	}

	// @Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable firstPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> course = courseRepository.findAll(firstPageWithThreeRecords).getContent();

		Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

		int totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

		System.out.println("Courses = " + course);
		System.out.println("Total Elements = " + totalElements);
		System.out.println("Total Pages = " + totalPages);
	}

	// @Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));

		List<Course> course = courseRepository.findAll(sortByTitle).getContent();

		System.out.println("Courses = " + course);
	}


	@Test
	public void saveCourseWithStudentAndTeacher() {

		Teacher teacher = Teacher.builder()
				.firstname("Alka")
				.lastname("Madam")
				.build();
		
		Parent parent = Parent.builder()
				.email("julin@zoho.com")
				.build();

		Student student = Student.builder()
				.fname("Julin")
				.lname("Thankachan")
				.city("Lucknow")
				.parent(parent)
				.dob(java.sql.Date.valueOf("1979-11-05"))
				.build();

		Course course = Course.builder()
				.credit(6)
				.title("Electronics Communication")
				.teacher(teacher)
				.build();

		course.addStudents(student);
		courseRepository.save(course);
	}

}