package com.globallogic.app5;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Ejercicio 5.1 (parcial) 
    	//Ejercicio 5.2 (parcial)
    	//Ejercicio 5.3 (parcial)
    	//Ejercicio 5.4 (parcial)
        Electrodomestico electrodomestico = new Electrodomestico("Philips", 40, 'b', "Gris");
        Heladera heladera = new Heladera("Philips", 40, 'b', "Gris", 500, true, 40);
        Televisor televisor = new Televisor();
        Cafetera cafetera = new Cafetera();
        
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
        
        electrodomesticos.add(electrodomestico);
        electrodomesticos.add(heladera);
        electrodomesticos.add(televisor);
        electrodomesticos.add(cafetera);
        
        System.out.println("Atributos y metodos de electrodoméstico");
        System.out.println("Marca: " + electrodomestico.getMarca());
        System.out.println("Peso: " + electrodomestico.getPeso());
        System.out.println("Consumo: " + electrodomestico.getConsumo());
        System.out.println("Color: " + electrodomestico.getColor());
        
        electrodomestico.encender();
        electrodomestico.apagar();
        
        
        System.out.println("-----------------------------------------");
        
        System.out.println("Atributos y metodos de heladera");
        System.out.println("Marca: " + heladera.getMarca());
        System.out.println("Peso: " + heladera.getPeso());
        System.out.println("Consumo: " + heladera.getConsumo());
        System.out.println("Color: " + heladera.getColor());
        System.out.println("Capacidad: " + heladera.getCapacidad());
        System.out.println("Tiene Freezer: " + heladera.getTieneFreezer());
        System.out.println("Capacidad freezer: " + heladera.getCapacidadFreezer());
         
        heladera.encender();
        heladera.apagar();
        
        System.out.println("\n ----------------------------------------- \n");
        
        System.out.println("\nelectrodomestico: \n");
        ListAttributesAndMethods(electrodomestico);
        System.out.println("\nheladera: \n");
        ListAttributesAndMethods(heladera);
        
        //Ej 5.2
         System.out.println("\nEj 5.2");
        for(Electrodomestico electro : electrodomesticos)
        {
        	electro.encender();
        }
        
        System.out.println("\n ----------------------------------------- \n");
        System.out.println("Ej 5.3");
        //Ejercicio 5.3
        
        Gato gato = new Gato();
        gato.setNombre("Mishi");
        gato.setPatas(4);
        
        System.out.println("Nombre del gato: " + gato.getNombre());
        System.out.println("Numero de patas: " + gato.getPatas());
        
        System.out.println("\n ----------------------------------------- \n");
        System.out.println("Ej 5.4");
        //Ejercicio 5.4
        
        Berlina berlina = new Berlina();
        berlina.avanzar();
    }
    
    private static void ListAttributesAndMethods(Electrodomestico objeto)
    {
    	try {
    		Field[] campos = objeto.getClass().getFields();
	    	Method[] metodos = objeto.getClass().getDeclaredMethods();
	    	
	    	for(Field c : campos)
	    	{
	    		System.out.println("Atributo: " + c.getName());	
	    	}
	    	
	    	for(Method m : metodos)
	    	{
	    		System.out.println("Metodo: " + m.getName());	
	    	}
    	}catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
}
