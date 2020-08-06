package com.globallogic.delegation;

public class ElectricalAppliance {

	private Integer power;
	
	public ElectricalAppliance() { setPower(500); }

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public void turnOn() { setPower(getPower() - 50); }
}
