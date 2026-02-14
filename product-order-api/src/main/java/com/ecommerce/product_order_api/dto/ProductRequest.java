package com.ecommerce.product_order_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequest {

	@NotBlank(message = "Name cannot be empty.")
	private String name;
	
	@Min(value = 0, message = "Price cannot be negative.")
	private double price;
	
	@Min(value = 0, message = "Quantity cannot be negative.")
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
