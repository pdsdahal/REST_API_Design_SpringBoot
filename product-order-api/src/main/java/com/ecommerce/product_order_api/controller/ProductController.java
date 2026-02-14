package com.ecommerce.product_order_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product_order_api.dto.ProductRequest;
import com.ecommerce.product_order_api.model.Product;
import com.ecommerce.product_order_api.service.ProductService;

import jakarta.validation.Valid;

//handle API request

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	// Constructor injection (Spring handles object creation)
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// Day 1: Get all products
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Day 1: Add product
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductRequest request) {
		Product p = new Product(request.getName(), request.getPrice(), request.getQuantity());
		return ResponseEntity.ok(productService.addProduct(p));
	}

	// Day 2: Get product by ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		if (product == null) {
			return ResponseEntity.status(404).body("Product not found");
		}
		return ResponseEntity.ok(product);
	}

	// Day 2: Delete product by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
		boolean deleted = productService.deleteProduct(id);
		if (!deleted) {
			return ResponseEntity.status(404).body("Product not found");
		}
		return ResponseEntity.ok("Product deleted successfully");

	}

	// Day 3: Update product
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProductById(@PathVariable Long id, @RequestBody @Valid ProductRequest request) {
		Product product = new Product(request.getName(), request.getPrice(), request.getQuantity());
		Product upProduct = productService.updateProduct(id, product);
		if (upProduct == null) {
			return ResponseEntity.status(404).body("Product not found");
		}
		return ResponseEntity.ok(upProduct);
	}
}
