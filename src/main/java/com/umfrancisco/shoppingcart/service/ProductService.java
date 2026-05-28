package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Product;

public interface ProductService {
	List<Product> findAll();
	Product save(Product product);
	Product findById(Long productId);
	void deleteById(Long productId);
	Product update(Product product, Long productId);
}
