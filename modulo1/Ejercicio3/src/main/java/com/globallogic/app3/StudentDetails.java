package com.globallogic.app3;

import java.util.Scanner;

public class StudentDetails {

	public static void main(String[] args) {
		// Ejercicio 3.4
		
		StudentDetails estudiante = new StudentDetails();
		
		System.out.println("Ingrese el valor a pasar por parametro: ");
		Scanner consola = new Scanner(System.in);
		int age = Integer.parseInt(consola.nextLine());
		estudiante.studentAge(age);
		consola.close();
	}

	private void studentAge(int age)
	{	
		System.out.println("La edad del estudiantes es: " + age);
	}
	
	private void studentAge()
	{
		int age = 0;
		age += 5;	
		System.out.println("La edad del estudiantes es: " + age);
	}
}
