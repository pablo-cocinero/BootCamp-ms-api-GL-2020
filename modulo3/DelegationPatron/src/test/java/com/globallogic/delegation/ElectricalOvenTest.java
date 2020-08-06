package com.globallogic.delegation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ElectricalOvenTest {

	ElectricalOven oven;
	@Before
	public void setUp() throws Exception {
		oven = new ElectricalOven();
	}

	@Test
	public void test() {
		oven.turnOn();
		oven.turnLed();
		oven.turnOn();
		oven.turnLed();
		oven.turnOn();
		oven.turnOn();
		assertEquals(0, oven.getPower());
	}

}
