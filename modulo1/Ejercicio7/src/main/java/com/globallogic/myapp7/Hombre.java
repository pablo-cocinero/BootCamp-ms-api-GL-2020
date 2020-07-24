package com.globallogic.myapp7;

// Ejercicio 7.3

public class Hombre implements Animal, Persona{

	public void dormir() {
		System.out.println("El hombre duerme muchas horas");
	}
	
	public void sonidoAnimal() {
		System.out.println("El hombre no hace sonidos de animal");
	}
	
	public void hablar()
	{
		System.out.println("Las personas hablan mucho");
	}
	
	public void come()
	{
		System.out.println("Se ejecuta método de la clase hombre");
	}
	
	public static void Main(String[] Args)
	{
		Hombre man = new Hombre();
		
		man.dormir();
		man.hablar();
		man.sonidoAnimal();
		man.come();
	}
}
