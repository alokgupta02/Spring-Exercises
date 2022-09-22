package com.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.jpa.entity.Parent;
import com.data.jpa.entity.Student;
import com.data.jpa.repository.StudentRepository;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	//@Test 
	public void saveStudent() { 
		Student student = Student.builder()
								.fname("Ankit") 
								.lname("Kumar") 
								.city("Pune")
								.dob(java.sql.Date.valueOf("1973-01-05")) 
								//.parentsName("Munesh")
								//.parentsNumber("3546463125") 
								//.parentsEmail("ankit@gmail.com") 
								.build();
	  
	  studentRepository.save(student);
	  
	  }

	// @Test
	public void saveStudentWithParents() {

		Parent parent = Parent.builder().name("Pankaj Mishra").email("pankajm@gmail.com").number("927302302").build();

		Student student = Student.builder().fname("Atul").lname("Mishra").dob(java.sql.Date.valueOf("2002-12-03"))
				.city("Amritsar").parent(parent).build();

		studentRepository.save(student);
	}

	//@Test
	public void getStudents() {
		List<Student> student = studentRepository.findAll();
		System.out.println("List " + student);
	}

	//@Test
	public void printStudentByFname() {

		List<Student> student = studentRepository.findByFname("Atul");
		System.out.println(student);
	}
	
	//@Test
	public void printStudentbyCh(){
		
		List<Student> student = studentRepository.findByFnameContaining("A");
		System.out.println("A containnig students are : " +student);
		}
	
	//@Test
	public void findByLastNameNotNull() {
		List<Student> student = studentRepository.findByLnameNotNull();
		System.out.println("Last name not Null : "+student );
	}
	
	//@Test
	public void findByParentName() {
		List<Student> student = studentRepository.findByParentName("Pankaj Mishra");
		System.out.println("Parents name is : " +student);
	}
	
	//@Test
	public void getStudentByCity() {
		Student student = studentRepository.getStudentByCity("Delhi");
		System.out.println("students is :  "+student);
	}
	
	//@Test
	public void getStudentNameByCity() {
		String student = studentRepository.getStudentNameByCity("Delhi");
		System.out.println("students is :  "+student);
	}
	
	//@Test
	public void getStudentNameByCitySQL() {
		Student student = studentRepository.getStudentNameByCitySQL("Delhi");
		System.out.println(student);
	}
	
	@Test
	public void updateStudentNameById() {
		studentRepository.updateStudentNameById("Pooja", 1);
	}
}
