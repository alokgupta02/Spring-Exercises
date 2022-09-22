package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public void addProduct(Product product);
	
	public void deleteProduct(long id);
	
	public Optional<Product> getProductById(long id);
	
	public List<Product> getAllProductsByCategoryId(int id);
	

}
