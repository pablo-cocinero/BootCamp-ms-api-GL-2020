package com.globallogic.app4;

public class WhileParImpar {

	public static void main(String[] args) {
		// Ejercicio 4.8
		
		int index=1;
		while(index <= 50)
		{
			if(index % 2 == 0)
			System.out.println("Valor iterado: " + index + " par");
			else
				System.out.println("Valor iterado: " + index + " impar");
			index++;
		}
	}

}
