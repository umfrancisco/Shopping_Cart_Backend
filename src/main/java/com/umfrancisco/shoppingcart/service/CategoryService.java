package com.umfrancisco.shoppingcart.service;

import java.util.List;

import com.umfrancisco.shoppingcart.model.Category;

public interface CategoryService {
	Category findById(Long id);
	Category findByName(String name);
	List<Category> findAll();
	Category add(Category category);
	Category update(Category category, Long id);
	void deleteById(Long id);
}
