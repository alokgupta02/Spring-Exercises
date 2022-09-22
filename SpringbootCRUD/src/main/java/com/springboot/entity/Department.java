package com.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	
	@NotBlank(message="Please Add Department Name")
	private @Getter @Setter String departmentName;
	private @Getter @Setter String departmentAddress;
	private @Getter @Setter String departmentCode;

}