package com.data.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "course")
@Table(name = "tbl_course_material")
public class CourseMaterial {
	
	@Id
	@SequenceGenerator(name = "course_material_sq", sequenceName = "course_material_sq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sq")
	private int courseMaterialId;
	
	private String url;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="course_id", referencedColumnName = "courseId")
	private Course course;
}
