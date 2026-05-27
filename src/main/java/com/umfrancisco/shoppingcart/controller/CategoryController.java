package com.umfrancisco.shoppingcart.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.Category;
import com.umfrancisco.shoppingcart.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<Category> findAll() {
		return categoryService.findAll();
	}
	
	@PostMapping
	public Category save(@RequestBody Category category) {
		System.out.println(this.getClass()+" - "+LocalDateTime.now()+": "+category);
		return categoryService.save(category);
	}
}
