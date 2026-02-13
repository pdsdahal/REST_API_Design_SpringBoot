package com.ecommerce.product_order_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ecommerce.product_order_api.model.Product;

//Holds business logic (in-memory for now)
@Service
public class ProductService {
	
	List<Product> productsList = new ArrayList<>();
	AtomicLong idGenerator = new AtomicLong(1);

	public List<Product> getAllProducts(){
		return productsList;
	}
	
	
	public Product AddProduct(Product product) {
		product.setId(idGenerator.incrementAndGet());
		productsList.add(product);
		return product;
	}
	
}
