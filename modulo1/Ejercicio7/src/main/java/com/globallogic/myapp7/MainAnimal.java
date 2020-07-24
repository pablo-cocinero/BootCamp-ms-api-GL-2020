package com.globallogic.myapp7;

/**
 * Ejercicio 7.2
 * Ejercicio 7.3
 *
 */
public class MainAnimal 
{
    public static void main( String[] args )
    {
    	System.out.println("-------- Ejercicio 7.2 ----------\n");
        Perro dog = new Perro();
        
        dog.dormir();
        
        dog.sonidoAnimal();
        
        System.out.println("\n-------- Ejercicio 7.3 ----------\n");
        
        Hombre.Main(args);
    }
}
