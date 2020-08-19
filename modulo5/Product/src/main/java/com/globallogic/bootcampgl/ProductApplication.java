package com.globallogic.bootcampgl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext	context = SpringApplication.run(ProductApplication.class, args);
		
		ProductRepository productRepo = context.getBean(ProductRepository.class);
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("C-00221", "Clavos"));
		productRepo.setProducts(products);
		
		System.out.println(productRepo.getById("C-00221"));
		
		
	}

}
