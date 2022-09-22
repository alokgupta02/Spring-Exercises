package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {

	private long id;
	private int categoryId;
	private String name;
	private double price;
	private String description;
	private String imageName;
}
