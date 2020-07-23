package com.globallogic.app5;

public class Heladera extends Electrodomestico 
{
	// Ejercicio 5.1 (parcial)
	//Declaro los atributos publicos para poder verlos con reflection desde la clase App
	public double capacidad;
	public boolean tieneFreezer;
	public double capacidadFreezer;
	
	public Heladera(String marca, double peso, char consumo, String color, double capacidad, boolean tieneFreezer, double capacidadFreezer) 
	{
		super(marca, peso, consumo, color);
		this.capacidad = capacidad;
		this.tieneFreezer = tieneFreezer;
		this.capacidadFreezer = capacidadFreezer;
	}
	
	
	
	public double getCapacidad()
	{
		return capacidad;
	}
	
	public void setCapacidad(double capacidad)
	{
		this.capacidad = capacidad;
	}
	public boolean getTieneFreezer()
	{
		return tieneFreezer;
	}
	
	public void setTieneFreezer(boolean tieneFreezer)
	{
		this.tieneFreezer = tieneFreezer;
	}
	public double getCapacidadFreezer()
	{
		return capacidadFreezer;
	}
	
	public void setCapacidadFreezer(double capacidadFreezer)
	{
		this.capacidadFreezer = capacidadFreezer;
	}
	
	public void guardarElemento()
	{
		System.out.println("Guardando elemento");
	}
	public void extraerElemento()
	{
		System.out.println("Extrayendo elemento");
	}
	
	@Override
	public void encender()
	{
		System.out.println("Encendiendo heladera");
	}
	
	@Override
	public void apagar()
	{
		System.out.println("Apagando heladera");
	}
}
