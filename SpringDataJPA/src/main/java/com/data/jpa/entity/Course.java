package com.data.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_course", uniqueConstraints = @UniqueConstraint(name = "id_unique", columnNames = "courseId"))
public class Course {

	@Id
	@SequenceGenerator(name = "course_sq", sequenceName = "course_sq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sq")
	// @Column(name="course_id")
	private int courseId;
	private String title;
	private int credit;

	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
	private Teacher teacher;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "studen_course_map", 
			joinColumns = @JoinColumn
			(
					name="course_id", 
					referencedColumnName = "courseId"
					),
			inverseJoinColumns = @JoinColumn
			(
					name="student_id", 
					referencedColumnName = "studentId"
					)
			)
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students==null) students = new ArrayList<>();
		students.add(student);
	}

}
