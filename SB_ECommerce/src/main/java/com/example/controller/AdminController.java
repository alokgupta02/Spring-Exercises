package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.ProductDTO;
import com.example.model.Category;
import com.example.model.Product;
import com.example.service.CategoryService;
import com.example.service.ProductService;

@Controller
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	public static String uploadDir = "src/main/resources/static/product_images";

	/* Controller for Admin Page */
	@GetMapping("/admin")
	public String adminHome(Model model) {
		return "admin";
	}

	@GetMapping("/admin/categories")
	public String getCategoires(Model model) {
		model.addAttribute("listCategories", categoryService.getAllCategories());
		return "categories";
	}

	@GetMapping("/admin/products")
	public String getProducts(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts());
		return "products";
	}

	/* Controller for Category Page */

	@GetMapping("/admin/categories/add")
	public String showCategoryForm(Model model) {
		Category categories = new Category();
		model.addAttribute("category", categories);
		return "AddCategory";
	}

	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/editCategory/{id}")
	public String editCategory(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "AddCategory";
		} else
			return "404";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id) {
		this.categoryService.deleteCategoryById(id);
		return "redirect:/admin/categories";
	}

	/* Controller for Product Page */

	@GetMapping("/admin/product/add")
	public String showAddProductForm(Model model) {
		ProductDTO productDto = new ProductDTO();
		model.addAttribute("productDTO", productDto);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "AddProduct";
	}

	@PostMapping("/saveProduct")
	public String productAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
			@RequestParam("productImage") MultipartFile file,
			@RequestParam(value = "imageName", required = false) String imgName) throws IOException {

		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		String imageUUID;
		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNamePath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNamePath, file.getBytes());
		} else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		productService.addProduct(product);
		return "redirect:/admin/products";
	}

	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable long id, Model model) {
		Product product = productService.getProductById(id).get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		productDTO.setImageName(product.getImageName());

		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("productDTO", productDTO);

		return "AddProduct";
	}

	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		this.productService.deleteProduct(id);
		return "redirect:/admin/products";
	}

}