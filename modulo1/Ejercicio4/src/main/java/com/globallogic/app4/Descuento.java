package com.globallogic.app4;

import java.util.Scanner;

public class Descuento {

	public static void main(String[] args) {
		// Ejercicio 4.3
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Ingrese el monto de la compra");
		double monto = keyboard.nextDouble();
		
		if(monto == 300)
		{
			System.out.println("El descuento es de: " + 20 * monto / 100);
		}else 
		if(monto > 350)
		{
			System.out.println("El descuento es de: " + 25 * monto / 100);
		}else
		{
			System.out.println("Sin descuentos, el total es: " + monto);
		}
		
		keyboard.close();
	}

}
