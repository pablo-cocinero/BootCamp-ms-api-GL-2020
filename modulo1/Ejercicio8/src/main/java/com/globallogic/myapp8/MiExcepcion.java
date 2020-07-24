package com.globallogic.myapp8;

//Ejercicio 8.4

public class MiExcepcion extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	String mensaje;
	
	public MiExcepcion() {
		
	}
	
	public MiExcepcion(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}

}
