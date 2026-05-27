package com.umfrancisco.shoppingcart.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.exception.ResourceNotFoundException;
import com.umfrancisco.shoppingcart.model.Category;
import com.umfrancisco.shoppingcart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found"));
	}

	@Override
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		System.out.println(this.getClass()+" - "+LocalDateTime.now()+": "+category);
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category, Long id) {
		return Optional.ofNullable(findById(id))
				.map(existingCategory -> {
					existingCategory.setName(category.getName());
					return categoryRepository.save(existingCategory);
				})
				.orElseThrow(() -> new ResourceNotFoundException("Category not found"));
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.findById(id)
			.ifPresentOrElse(categoryRepository::delete, () -> {
				throw new ResourceNotFoundException("Category not found");
			});
	}

}
