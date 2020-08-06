package com.globallogic.delegation;

public class LedAppliance {
	
	public LedAppliance() {  }
	
	public Integer turnOn(Integer power) { return power -= 100; } 
}
