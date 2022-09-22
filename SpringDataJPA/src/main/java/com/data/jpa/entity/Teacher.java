package com.data.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Teacher {

	@Id
	@SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "teacher_seq")
	private int teacherId;
	private String firstname;
	private String lastname;

	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "teacher_id", referencedColumnName = "teacherId")
	private List<Course> courses;
	*/

}
