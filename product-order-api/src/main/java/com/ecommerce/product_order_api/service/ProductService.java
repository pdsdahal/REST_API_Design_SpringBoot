package com.ecommerce.product_order_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ecommerce.product_order_api.model.Product;

//Holds business logic (in-memory for now)
@Service
public class ProductService implements CommandLineRunner {
	
	private final List<Product> productsList = new ArrayList<>();
	private final AtomicLong idGenerator = new AtomicLong(1);

	// Day 1: Get All Products
	public List<Product> getAllProducts() {
		return productsList;
	}

	// Day 1: Add Product
	public Product addProduct(Product product) {
		product.setId(idGenerator.incrementAndGet());
		productsList.add(product);
		return product;
	}

	// Day 2: Delete Product
	public boolean deleteProduct(Long id) {
		return productsList.removeIf(p -> p.getId().equals(id));
	}

	// Day 2: Get Product by ID
	public Product getProductById(Long id) {
		return productsList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

	// Day 3: Update Product
	public Product updateProduct(Long id, Product product) {
		for (Product p : productsList) {
			if (p.getId().equals(id)) {
				p.setName(product.getName());
				p.setPrice(product.getPrice());
				p.setQuantity(product.getQuantity());
				return p;
			}
		}
		return null;
	}

	// Day 3: Initialize sample products
	@Override
	public void run(String... args) throws Exception {
		addProduct(new Product(null, "iPhone", 999.99, 10));
		addProduct(new Product(null, "Samsung Galaxy", 899.99, 8));
	}
}
