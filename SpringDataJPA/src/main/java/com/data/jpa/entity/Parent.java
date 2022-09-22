package com.data.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({ 
		@AttributeOverride(name = "name", column = @Column(name = "parents_name")),
		@AttributeOverride(name = "email", column = @Column(name = "email_address")),
		@AttributeOverride(name = "number", column = @Column(name = "parents_number"))
})
public class Parent {

	private String name;

	private String email;

	private String number;

}
