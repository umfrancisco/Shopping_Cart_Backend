package com.umfrancisco.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.shoppingcart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
