package com.globallogic.bootcampgl.junitTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static int suma(int a, int b) {
    	return a + b;
    }
    
    public static boolean iteracion(int limite)
    {
    	for(int i= 0; i < limite ; i++)
    	{
    		if(i == 3)
    			return true;
    	}
    	return false;
    }
}
