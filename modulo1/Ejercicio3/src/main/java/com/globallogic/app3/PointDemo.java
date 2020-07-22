package com.globallogic.app3;

public class PointDemo {

	public static void main(String[] args) {
		// Ejercicio 3.5 (parcial)
		
		VariableInstancia vl = new VariableInstancia();
		
		vl.setEngPoints(50);
		vl.setMathsPoints(80);
		
		System.out.println("Valor de endPoints: " + vl.getEngPoints());
		System.out.println("Valor de mathsPoints: " + vl.getMathsPoints());
	}

}
