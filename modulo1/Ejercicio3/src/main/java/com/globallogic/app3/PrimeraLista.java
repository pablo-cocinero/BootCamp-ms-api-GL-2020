package com.globallogic.app3;
import java.util.ArrayList;

public class PrimeraLista {

	public static void main(String[] args) {
		
		// Ejercicio 3.3
		
		ArrayList<String> letters = new ArrayList<String>();
		
		
		letters.add("A");
		letters.add("B");
		letters.add("C");
		
		ImprimirLista(letters);
		
		System.out.println("Cantidad de elementos: " + letters.size());
		
		letters.add(0, "X");
		
		ImprimirLista(letters);
	}

	private static void ImprimirLista(ArrayList<String> letters)
	{
		System.out.println("Elementos de la lista: ");
		
		for(String s: letters)
		{
			System.out.println(s);
		}
	}
	
}
