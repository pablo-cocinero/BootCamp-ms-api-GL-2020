package com.globallogic.bootcamp.patterns;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Playstation playstation = new Playstation("Resident Evil");
    	System.out.println("\n" + playstation.askMyGame());
    	playstation.setVideogame(new Game("Brawlhalla"));
    	System.out.println("\n" + playstation.askMyGame());
    	playstation.setVideogame(null);
    	System.out.println("\n" + playstation.askMyGame());
    
    }
}
