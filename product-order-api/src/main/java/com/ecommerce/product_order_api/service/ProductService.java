package com.ecommerce.product_order_api.service;

import java.util.List;

import com.ecommerce.product_order_api.model.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product addProduct(Product product);

	boolean deleteProduct(Long id);

	Product getProductById(Long id);

	Product updateProduct(Long id, Product product);
}