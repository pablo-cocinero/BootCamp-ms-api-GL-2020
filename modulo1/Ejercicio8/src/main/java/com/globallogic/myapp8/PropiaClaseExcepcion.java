package com.globallogic.myapp8;

//Ejercicio 8.4

public class PropiaClaseExcepcion {

	public static void main(String[] args) {
		
		
		try {
			
			throw new MiExcepcion("String almacenado en MiExcepcion");
			
		}catch(MiExcepcion e)
		{
			System.out.println(e.getMensaje());
		}

	}

}
