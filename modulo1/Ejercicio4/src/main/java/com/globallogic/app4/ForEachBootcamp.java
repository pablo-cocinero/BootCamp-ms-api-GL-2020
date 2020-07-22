package com.globallogic.app4;

public class ForEachBootcamp {

	public static void main(String[] args) {
		// Ejercicio 4.11
		
		String name = "BootCamp 2020";
		
		for(char letra : name.toCharArray())
		{
			System.out.println("Caracter: " + letra);
		}

	}

}
