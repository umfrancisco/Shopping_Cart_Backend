package com.umfrancisco.shoppingcart.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.Image;
import com.umfrancisco.shoppingcart.response.ApiResponse;
import com.umfrancisco.shoppingcart.service.ImageService;
import com.umfrancisco.shoppingcart.service.ImageServiceImpl;

@RestController
@RequestMapping("api/image")
public class ImageController {
	
	private final ImageService imageService;
	
	public ImageController(ImageServiceImpl imageService) {
		this.imageService = imageService;
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> save(@RequestBody List<String> imagesUrl, @RequestBody Long productId) {
		List<Image> images = imageService.save(imagesUrl, productId);
		return ResponseEntity.ok(new ApiResponse("Success", images));
	}
	
	@GetMapping
	public List<Image> findAll() {
		return imageService.findAll();
	}
	
}
