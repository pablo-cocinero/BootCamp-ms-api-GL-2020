package com.globallogic.myapp7;

public interface Persona {
	// Ejercicio 7.3
	
	public void hablar();
	public void dormir();
	public default void come() {
		System.out.println("Comiendo...");
	}
}
