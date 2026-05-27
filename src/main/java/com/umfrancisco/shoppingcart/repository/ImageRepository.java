package com.umfrancisco.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umfrancisco.shoppingcart.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	
}
