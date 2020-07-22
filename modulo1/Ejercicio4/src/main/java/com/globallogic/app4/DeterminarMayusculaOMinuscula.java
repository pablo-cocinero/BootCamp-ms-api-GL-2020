package com.globallogic.app4;

import java.util.Scanner;

public class DeterminarMayusculaOMinuscula {

	public static void main(String[] args) {
		// Ejercicio 4.2
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Ingrese una letra: ");
		char letra =  keyboard.nextLine().charAt(0);
		if(Character.isLowerCase(letra))
		{
			System.out.println("La letra ingresada es minúscula");
		}else 
		{
			System.out.println("La letra ingresada es mayúscula");
		}
		keyboard.close();
	}

}
