package com.globallogic.app5;

public class Cafetera extends Electrodomestico{
	//Ejercicio 5.2 (parcial)
	double litros;
	
	public void elegirSabor(String sabor)
	{
		System.out.println("Sabor elegido: "+ sabor);
	}
	
	@Override
	public void encender()
	{
		System.out.println("Encendiendo cafetera");
	}
}
