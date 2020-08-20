package com.globallogic.bootcampms.initializrOrder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InitializrOrderApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InitializrOrderApplication.class, args);
		
		OrderFactory orderFactory = new OrderFactory(context.getBean(Order.class));
		System.out.println(orderFactory.getNewOrder());
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
	}

}
