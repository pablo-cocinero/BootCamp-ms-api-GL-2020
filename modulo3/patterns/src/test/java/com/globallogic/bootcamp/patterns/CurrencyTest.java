package com.globallogic.bootcamp.patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrencyTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		assertEquals(Currency.getInstance(),Currency.getInstance());
	}

}
