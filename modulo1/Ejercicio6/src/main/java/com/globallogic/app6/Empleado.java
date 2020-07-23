package com.globallogic.app6;

public class Empleado extends Persona{

	private int id, cantidadHijos;
	private String nombre;
	private float sueldoBase, horasExtraDelMes, irpf;
	private boolean casado;
	private static float importeHoraExtra;
	
	public Empleado(int dni)
	{
		super(dni);
	}
	public int getDni() {return super.getDni();}
	public int getId() {return id;}
	public int getCantidadHijos() {return cantidadHijos;}
	public String getNombre() {return nombre;}
	public float getSueldoBase() {return sueldoBase;}
	public float getHorasExtraDelMes() {return horasExtraDelMes;}
	public float getIrpf() {return irpf;}
	public boolean getCasado() {return casado;}
	public float getImporteHoraExtra() {return importeHoraExtra;}
	
	public void setDni(int dni) { super.setDni(dni);}
	public void setId(int id) { this.id = id ;}
	public void setCantidadHijos(int cantidadHijos) { this.cantidadHijos = cantidadHijos;}
	public void setNombre(String nombre) { this.nombre = nombre ;}
	public void setSueldoBase(float sueldoBase) { this.sueldoBase = sueldoBase;}
	public void setHorasExtraDelMes(float horasExtraDelMes) { this.horasExtraDelMes = horasExtraDelMes;}
	public void setIrpf(float irpf) { this.irpf = irpf;}
	public void setCasado(boolean casado) { this.casado = casado;}
	public  static void setImporteHoraExtra(float importeHoraExtra) { Empleado.importeHoraExtra = importeHoraExtra;}
	
	public  float calculoComplementoHorasExtras() {
		return horasExtraDelMes * importeHoraExtra;
	}
	
	public float sueldoBruto() {
	return sueldoBase + calculoComplementoHorasExtras();
	}
	public float sueldoNeto() {
		return sueldoBruto() - calculoIrpf();
		}
	
	public float calculoIrpf() {
		if(casado)
		{
			return sueldoBruto() * (irpf - 2 - cantidadHijos);
		}else
		{
			return sueldoBruto() * (irpf - cantidadHijos);
		}
	}
	@Override
	public String toString() {
	
		String Result =  "\nid: " + id + "\nnombre: " + nombre + "\nSueldo Base : " + sueldoBase + "\nHoras Extra: " + horasExtraDelMes + "\nTipo IRPF: " + irpf + "\nCasado: ";
		
		if(casado)
			Result += "Si";
		else
			Result += "No";
		Result += "\nCantidad de hijos: " + cantidadHijos;
	return Result;
	}
	
	}

