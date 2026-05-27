package com.umfrancisco.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.exception.ResourceNotFoundException;
import com.umfrancisco.shoppingcart.model.Image;
import com.umfrancisco.shoppingcart.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	
	private final ImageRepository imageRepository;
	private final ProductService productService;
	
	public ImageServiceImpl(ImageRepository imageRepository, ProductService productService) {
		this.imageRepository = imageRepository;
		this.productService = productService;
	}
	
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	@Override
	public Image findById(Long id) {
		return imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found, id="+id));
	}

	@Override
	public void deleteById(Long id) {
		imageRepository.findById(id).ifPresentOrElse(imageRepository::delete, () -> new ResourceNotFoundException("Image not found"));
	}

	@Override
	public List<Image> save(List<String> imagesUrl, Long productId) {
		var product = productService.findById(productId);
		List<Image> images = new ArrayList<>();
		for (var url : imagesUrl) {
			var image = new Image(url, product);
			imageRepository.save(image);
			images.add(image);
		}
		product.setImages(images);
		return images;
	}

	@Override
	public void update(Image image, Long imageId) {
		var existingImage = findById(imageId);
		image.setUrl(image.getUrl());
		imageRepository.save(existingImage);
	}
}
