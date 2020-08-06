package com.globallogic.bootcamp.patterns;

public class Product {

	private String name;
	private static final Product instance = new Product();
	
	private Product() {name = "Clavos"; }

	public String getName() {
		return name;
	}

	public static Product getInstance() {
		return instance;
	}
}
