package com.globallogic.bootcamp.patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Order order1 = new Order("Order 1", 500.0, Currency.getInstance());
		Order order2 = new Order("Order 2", 1000.0, Currency.getInstance());
		
		assertEquals(order1.getCurrency(), order2.getCurrency());
	}
	
	@Test
	void testProduct() {
		Order order1 = new Order("Order 1", 500.0, Currency.getInstance());
		Order order2 = new Order("Order 2", 1000.0, Currency.getInstance());
		
		assertEquals(order1.getProduct(), order2.getProduct());
	}

}
