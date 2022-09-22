package com.data.jpa.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email_address"))

public class Student {

	@Id
	@SequenceGenerator(name = "student_seq", sequenceName = "student_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	private int studentId;

	private String fname;
	private String lname;

	@Temporal(TemporalType.DATE)
	private java.util.Date dob;

	private String city;
	
	@Embedded
	private Parent parent;


}
