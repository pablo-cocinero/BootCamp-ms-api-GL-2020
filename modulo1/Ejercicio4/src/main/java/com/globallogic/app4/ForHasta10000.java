package com.globallogic.app4;

public class ForHasta10000 {

	public static void main(String[] args) {
		// Ejercicio 4.5
		int sumar = 0;
		for(int i=0; i <= 10000; i++)
		{
			if(i % 20 == 0)
			{
				sumar++;
			}
		}
		System.out.println(sumar);
	}

}
