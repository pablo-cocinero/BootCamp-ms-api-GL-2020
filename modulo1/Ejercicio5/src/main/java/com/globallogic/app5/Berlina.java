package com.globallogic.app5;

public class Berlina extends Automovil{

	@Override
	public void retroceder()
	{
		System.out.println("Soy el metodo retroceder de Berlina");
	}
	
	@Override
	public void avanzar() {
		System.out.println("Soy el metodo avanzar de Berlina");
	}
}
