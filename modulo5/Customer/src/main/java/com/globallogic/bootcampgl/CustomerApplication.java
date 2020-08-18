package com.globallogic.bootcampgl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer customer = new Customer("Jose Perez", 234567890,12342);
		System.out.println(customer);
		
	}

}
