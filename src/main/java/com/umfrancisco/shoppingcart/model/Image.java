package com.umfrancisco.shoppingcart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String url;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public Image() {
		
	}
	
	public Image(String url, Product product) {
		this.url = url;
		this.product = product;
	}
	
	public Image(Long id, String url, Product product) {
		this.id = id;
		this.url = url;
		this.product = product;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + ", product=" + product + "]";
	}
}
