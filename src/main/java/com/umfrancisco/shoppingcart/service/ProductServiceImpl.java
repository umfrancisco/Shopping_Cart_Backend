package com.umfrancisco.shoppingcart.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Product save(Product product) {
		return repository.save(product);
	}
	
	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Product findById(Long productId) {
		return repository.findById(productId).get();
	}

	@Override
	public void deleteById(Long productId) {
		var product = repository.findById(productId).get();
		if (product != null) {
			repository.delete(product);
		}
	}

	@Override
	public Product update(Product product, Long productId) {
		var updatedProduct = repository.findById(productId).get();
		if (updatedProduct != null) {
			updatedProduct.setName(product.getName());
			updatedProduct.setBrand(product.getBrand());
			updatedProduct.setPrice(product.getPrice());
			updatedProduct.setQuantity(product.getQuantity());
			updatedProduct.setDescription(product.getDescription());
			updatedProduct.setImageUrl(product.getImageUrl());
			updatedProduct.setCategory(product.getCategory());
		}
		return updatedProduct;
	}
}
