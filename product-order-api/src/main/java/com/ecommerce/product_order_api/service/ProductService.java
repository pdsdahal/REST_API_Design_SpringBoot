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

	public List<Product> getAllProducts() {
		return productsList;
	}

	public Product AddProduct(Product product) {
		product.setId(idGenerator.incrementAndGet());
		productsList.add(product);
		return product;
	}

	public boolean deleteProduct(Long id) {
		return productsList.removeIf(p -> p.getId().equals(id));
	}

	public Product getProduct(Long id) {
		return productsList.stream().filter(p -> p.getId().equals(id))
				.findFirst().orElse(null);
	}

}
