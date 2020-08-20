package com.globallogic.bootcampms.initializrProduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InitializrProductApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext	context = SpringApplication.run(InitializrProductApplication.class, args);
		
		ProductRepository productRepo = context.getBean(ProductRepository.class);
		List<Product> products = new ArrayList<Product>();
		Product product = context.getBean(Product.class);
		products.add(product);
		productRepo.setProducts(products);
		
		System.out.println(productRepo.getById("C-00221"));
	}
	
	

}
