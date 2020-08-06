package com.globallogic.bootcamp.patterns;

public class Order {

	
	String description;
	Double count;
	Product product;
	Currency currency;
	
	
	public Order(String description, Double count, Currency currency) {
		this.description = description;
		this.count = count;
		this.currency = currency;
		product = Product.getInstance();
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public Product getProduct() {
		return product;
	}

}
