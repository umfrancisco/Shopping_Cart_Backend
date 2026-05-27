package com.umfrancisco.shoppingcart.service;

import java.util.List;

import com.umfrancisco.shoppingcart.model.Image;

public interface ImageService {
	Image findById(Long id);
	void deleteById(Long id);
	List<Image> save(List<String> imagesUrl, Long productId);
	void update(Image image, Long imageId);
}
