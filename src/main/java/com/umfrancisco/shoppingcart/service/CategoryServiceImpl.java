package com.umfrancisco.shoppingcart.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.model.Category;
import com.umfrancisco.shoppingcart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category add(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category category, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
