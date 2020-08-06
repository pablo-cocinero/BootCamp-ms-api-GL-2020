package com.globallogic.bootcamp.patterns;

public class Currency {

	private String name;
	private static final Currency instance = new Currency();
	
	private Currency()
	{
		this.setName("ARS");
	}
	
	public static Currency getInstance() {
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
