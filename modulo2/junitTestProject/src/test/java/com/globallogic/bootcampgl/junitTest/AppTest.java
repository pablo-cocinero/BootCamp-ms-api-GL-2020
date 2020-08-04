package com.globallogic.bootcampgl.junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
	
	private static String stringUno = "algo distinto";
	private static String stringDos = "algo ej 1.5";
	private static String stringTres = "algo distinto";

	@Test
	void test() {
		assertEquals("Test","test");
	}
	
	@Test
	void testStrings()
	{
		assertEquals(stringUno, stringDos);
		assertFalse(stringUno.equals(stringTres));
	}
	
	@Test
	void testDesigualdades()
	{
		assertTrue(25 < 12);
		assertFalse(25 < 27);
	}
	
	@Test
	void testNull()
	{
		Long variable = 1L;
		
		assertNull(variable);
		
		variable = null;
		
		assertNotNull(variable);
	}
	
	@Test
	void testSuma()
	{
		int a = 3;
		int b = 8;
		
		assertEquals(11, App.suma(a,b));
		assertEquals(12, App.suma(a,b), "El resultado está mal: ");
	}
	
	@Test
	void testIteracion()
	{
		assertFalse(App.iteracion(5),"Esta variable no es true");
		
		assertTrue(App.iteracion(2),"Esta variable no es false");
	}

}
