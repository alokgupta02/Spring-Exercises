package com.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer >{
	
	//Custom methods
	List<Student> findByFname(String firstName);
	
	List<Student> findByFnameContaining(String ch);
	
	List<Student> findByLnameNotNull();
	
	List<Student> findByParentName(String parentName);

	//JPQL
	@Query("select s from Student s where s.city = ?1")
	Student getStudentByCity(String city);
	
	//JPQL
	@Query("select s.fname, s.lname from Student s where s.city = ?1")
	String getStudentNameByCity(String city);
	
	//Native SQL Query
	@Query(value = "select * from tbl_student s where s.city =?1",
			nativeQuery = true)
	Student getStudentNameByCitySQL(String city);
	
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set fname = ?1 where student_id =?2",nativeQuery = true)
	int updateStudentNameById(String firstName, int studentId);
}
