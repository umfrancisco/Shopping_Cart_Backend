package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Product>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Product product) {
		try {
			return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<String> update(@RequestBody Product product, @PathVariable Long productId) {
		try {
			service.update(product, productId);
			return new ResponseEntity<>("Updated "+product, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> delete(@PathVariable Long productId) {
		try {
			service.deleteById(productId);
			return new ResponseEntity<>("Deleted product with id "+productId, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
