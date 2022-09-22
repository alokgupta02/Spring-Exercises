package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategoryById(int id) {
		this.categoryRepository.deleteById(id);

	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public void addCategory(Category category) {
		this.categoryRepository.save(category);
	}
}