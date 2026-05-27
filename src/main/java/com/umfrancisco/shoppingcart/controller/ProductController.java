package com.umfrancisco.shoppingcart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.service.ProductService;
import com.umfrancisco.shoppingcart.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private final ProductService service;
	
	public ProductController(ProductServiceImpl service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Product> findAll() {
		return service.findAll();
	}
}
