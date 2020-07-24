package com.globallogic.myapp8;

import java.util.ArrayList;
/**
 * Ejercicio 8.1
 * Ejercicio 8.2
 * Ejercicio 8.3
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Ejercicio8Punto1();
    	
    	Ejercicio8Punto2();
    	
    	Ejercicio8Punto3();
    }
    
    public static void Ejercicio8Punto1()
    {
    	try {
    		
    		System.out.println("-------- Ejercicio 8.1 ---------\n");	
    		
        	Exception exception = new Exception("Instancia de exception");
        	throw exception;
        }catch(Exception exception)
        {
        	System.out.println("String: " + exception.getMessage());
        }finally
        {
        	System.out.println("Esto se ejecuta sin importar si se presentan errores");
        }
    }
    
    public static void Ejercicio8Punto2()
    {
    	try {
    	
    	System.out.println("\n-------- Ejercicio 8.2 ---------\n");	
    		
    	ArrayList<String> arreglo = null;
    	arreglo.add("Intento fallido");
    	
    	}catch(Exception e)
    	{
    		System.out.println("Se produjo una excepción. null");
    	}
    }
    
    public static void Ejercicio8Punto3()
    {
    	try {
    	
    	System.out.println("\n-------- Ejercicio 8.3 ---------\n");	
    		
    	String[] arreglo = new String[5];
    	
    	
    	for(int i=0; i < 10; i++)
    	{
    		arreglo[i] = "Fuera de indice";
    	}
    	
    	}catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println("Excepción: índice de array fuera de límites");
    	}
    }
}
