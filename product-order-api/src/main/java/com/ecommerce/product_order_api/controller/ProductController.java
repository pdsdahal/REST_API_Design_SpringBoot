package com.ecommerce.product_order_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product_order_api.model.Product;
import com.ecommerce.product_order_api.service.ProductService;

//handle API request

@RestController
@RequestMapping("/products")
public class ProductController {

	ProductService productService;

	public ProductController() {
		productService = new ProductService();
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.AddProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		boolean result = productService.deleteProduct(id);
		return result ? "Product deleted successfully!!!" : "Product not found"; 
	}

}
