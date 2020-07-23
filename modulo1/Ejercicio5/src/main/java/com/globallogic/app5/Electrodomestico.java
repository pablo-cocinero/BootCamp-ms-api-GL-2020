package com.globallogic.app5;

public class Electrodomestico {

	// Ejercicio 5.1 (parcial)
	//Declaro los atributos publicos para poder verlos con reflection desde la clase App
	public String marca;
	public double peso;
	public char consumo;
	public String color;
	
	public Electrodomestico(String marca, double peso, char consumo, String color)
	{
		this.marca = marca;
		this.peso = peso;
		this.consumo = consumo;
		this.color = color;
	}
	 
	public Electrodomestico() {}
	
	public void encender() {
		System.out.println("Encendiendo electrodoméstico");
	}
	
	public void apagar() {
		System.out.println("Apagando electrodoméstico");
	}
	
	public String getMarca()
	{
		return marca;
	}
	
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	public double getPeso()
	{
		return peso;
	}
	
	public void setPeso(double peso)
	{
		this.peso = peso;
	}
	public char getConsumo()
	{
		return consumo;
	}
	public void setConsumo(char consumo)
	{
		this.consumo = consumo;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	
}
