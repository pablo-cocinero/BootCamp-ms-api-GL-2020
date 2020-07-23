package com.globallogic.app5;

public class Televisor extends Electrodomestico{
	//Ejercicio 5.2 (parcial)
	
	double pulgadas;
	String resolucion;
	
	public void cambiarCanal() {
	System.out.println("Cambiando canal...");
	}
	
	@Override
	public void encender()
	{
		System.out.println("Encendiendo televisor");
	}
}
