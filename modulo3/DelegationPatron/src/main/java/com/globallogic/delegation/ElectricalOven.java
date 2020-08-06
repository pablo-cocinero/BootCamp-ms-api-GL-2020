package com.globallogic.delegation;

public class ElectricalOven extends ElectricalAppliance {

	LedAppliance ledApliance;
	
	public ElectricalOven() { super(); ledApliance = new LedAppliance(); }
	
	@Override
	public void turnOn() { setPower(getPower() - 75); }
	
	public void turnLed() { setPower(ledApliance.turnOn(getPower()));}
}
