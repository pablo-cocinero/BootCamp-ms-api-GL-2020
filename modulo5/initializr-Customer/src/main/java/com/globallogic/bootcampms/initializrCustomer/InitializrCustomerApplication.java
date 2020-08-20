package com.globallogic.bootcampms.initializrCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InitializrCustomerApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InitializrCustomerApplication.class, args);
		Customer customer = context.getBean(Customer.class);
		System.out.println(customer);
	}

	
}
