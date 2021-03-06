package com.globallogic.bootcampgl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner{

	public static void main(String[] args) {
		
		 SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		OrderFactory orderFactory = new OrderFactory();
		System.out.println(orderFactory.getNewOrder());
		
	}

}
