package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.request.ProductRequest;
import com.umfrancisco.shoppingcart.service.ProductService;
import com.umfrancisco.shoppingcart.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductServiceImpl productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	@PostMapping
	public Product save(@RequestBody ProductRequest product) {
		return productService.save(product);
	}
}
