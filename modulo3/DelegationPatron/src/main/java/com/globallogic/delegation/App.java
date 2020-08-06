package com.globallogic.delegation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ElectricalOven oven = new ElectricalOven();
        
        System.out.println("Energia inicial: " + oven.getPower());
        oven.turnOn();
        System.out.println("Despues de turn on: " + oven.getPower());
        oven.turnLed();
        System.out.println("Despues de turn led: " + oven.getPower());
    }
}
