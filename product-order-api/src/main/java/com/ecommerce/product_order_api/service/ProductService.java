package com.ecommerce.product_order_api.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ecommerce.product_order_api.model.Product;
import com.ecommerce.product_order_api.repository.ProductRepository;

//Holds business logic (in-memory for now)
@Service
public class ProductService implements CommandLineRunner {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Day 1: Get All Products
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// Day 1: Add Product
	public Product addProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	// Day 2: Delete Product
	public boolean deleteProduct(Long id) {
		if (!productRepository.existsById(id)) {
			return false;
		}
		productRepository.deleteById(id);
		return true;
	}

	// Day 2: Get Product by ID
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	// Day 3: Update Product
	public Product updateProduct(Long id, Product product) {
		return productRepository.findById(id)
                .map(p -> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    p.setQuantity(product.getQuantity());
                    return productRepository.save(p);
                })
                .orElse(null);
		}

	// Day 3: Initialize sample products
	@Override
	public void run(String... args) throws Exception {
		addProduct(new Product("iPhone", 999.99, 10));
		addProduct(new Product("Samsung Galaxy", 899.99, 8));
	}
}
