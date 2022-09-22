package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Category;

public interface CategoryService {
	
	// Create
	public void addCategory(Category category);
	
	// Read
	public List<Category> getAllCategories();
	
	// Update
	public Optional<Category> getCategoryById(int id);
	
	// Delete
	public void deleteCategoryById(int id);

}
