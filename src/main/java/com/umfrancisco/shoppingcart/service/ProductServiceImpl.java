package com.umfrancisco.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.exception.ProductNotFoundException;
import com.umfrancisco.shoppingcart.model.Category;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.repository.ProductRepository;
import com.umfrancisco.shoppingcart.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Product add(ProductRequest request) {
		return null;
	}
	
	private Product createProduct(ProductRequest request, Category category) {
		String name = request.getName();
		String brand = request.getBrand();
		BigDecimal price = request.getPrice();
		int inventory = request.getInventory();
		String description = request.getDescription();
		return new Product(name, brand, price, inventory, description, category);
	}

	@Override
	public Product findById(Long productId) {
		return repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
	}

	@Override
	public void deleteById(Long productId) {
		repository.findById(productId)
			.ifPresentOrElse(repository::delete, () -> {
				throw new ProductNotFoundException("Product not found");
			});
	}

	@Override
	public void update(Product product, Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Product> findByCategory(String category) {
		return repository.findByCategoryName(category);
	}

	@Override
	public List<Product> findByBrand(String brand) {
		return repository.findByBrand(brand);
	}

	@Override
	public List<Product> findByCategoryAndBrand(String category, String brand) {
		return repository.findByCategoryNameAndBrand(category, brand);
	}

	@Override
	public List<Product> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Product> findByBrandAndName(String brand, String name) {
		return repository.findByBrandAndName(brand, name);
	}

	@Override
	public Long countByBrandAndName(String brand, String name) {
		return repository.countByBrandAndName(brand, name);
	}
}
