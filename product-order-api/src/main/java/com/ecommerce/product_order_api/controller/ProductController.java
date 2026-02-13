package com.ecommerce.product_order_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product_order_api.model.Product;
import com.ecommerce.product_order_api.service.ProductService;

//handle API request

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	//Spring Boot manages object creation for you, 
	//so you never have to use new for Spring-managed beans like services, repositories, etc.
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
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	// Day 2: Get product by ID
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		if(product == null) {
			throw new RuntimeException("Product not found");
		}
		return product;
	}

	// Day 2: Delete product by ID
	@DeleteMapping("/{id}")
	public String deleteProductById(@PathVariable Long id) {
		boolean result = productService.deleteProduct(id);
		return result ? "Product deleted successfully!!!" : "Product not found";
	}

	// Day 3: Update product
	@PutMapping("/{id}")
	public Product updateProductById(@PathVariable Long id, @RequestBody Product product) {
		Product upProduct = productService.updateProduct(id, product);
		if (upProduct == null) {
			throw new RuntimeException("Product not found");
		}
		return upProduct;
	}
}
