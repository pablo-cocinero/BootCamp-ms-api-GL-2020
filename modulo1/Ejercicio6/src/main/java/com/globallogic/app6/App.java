package com.globallogic.app6;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Empleado[] empleados;
       int cantidadEmpleados;
       Scanner keyboard = new Scanner(System.in);
       
       do {
       System.out.println("Ingrese el numero de empleados a registrar (máximo 20)");
       cantidadEmpleados = Integer.parseInt(keyboard.nextLine());
       }while(cantidadEmpleados < 0 || cantidadEmpleados > 20);
       
       empleados = new Empleado[cantidadEmpleados];
       
       for(int i=0; i < cantidadEmpleados; i++)
       {
    	   System.out.println("Ingrese el dni del nuevo empleado:");
    	   Empleado emp = new Empleado(Integer.parseInt(keyboard.nextLine()));
    	   System.out.println("Ingrese el nombre del empleado:");
    	   emp.setNombre(keyboard.nextLine());
    	   System.out.println("Ingrese el sueldo base del empleado:");
    	   emp.setSueldoBase(Float.parseFloat(keyboard.nextLine()));
    	   System.out.println("Ingrese las horas extras realizadas por el empleado:");
    	   emp.setHorasExtraDelMes(Float.parseFloat(keyboard.nextLine()));
    	   System.out.println("Ingrese tipo IRPF del empleado(%): ");
    	   emp.setIrpf(Float.parseFloat(keyboard.nextLine()));
    	   boolean flag = false;
    	   while(!flag){
	    	   System.out.println("El empreado es casado: (s/n)");
	    	   char casado = keyboard.nextLine().charAt(0);
	    	   if(casado == 's')
	    		   {emp.setCasado(true);
	    		   flag = true;}
	    	   else if(casado == 'n')
	    		   {emp.setCasado(false);
	    	   	flag = true;}
	       }
	       System.out.println("Ingrese cantidad de hijos del empleado:");
		   emp.setCantidadHijos(Integer.parseInt(keyboard.nextLine()));
	       empleados[i] = emp;
       }
       
       System.out.println("Ingrese el importe correspondiente al pago de horas extra: ");
	   Empleado.setImporteHoraExtra(Float.parseFloat(keyboard.nextLine()));
	   
SortEmpleadosPorRemuneracionExtra(empleados);
       
	   System.out.println("El empleado que mas cobra por horas extra es: " + empleados[cantidadEmpleados - 1].getNombre());
	   System.out.println("El empleado que menos cobra por horas extra es: " + empleados[0].getNombre());
	   
	   SortEmpleadosPorSalario(empleados);
	   
	   System.out.println("El empleado que mas cobra es: " + empleados[cantidadEmpleados - 1].getNombre());
	   System.out.println("El empleado que menos cobra es: " + empleados[0].getNombre());
	   
	   System.out.println("Listado de empleados por salario de menor a mayor: ");
	   
	   for(Empleado e : empleados)
	   {
		  System.out.println(e.toString()); 
	   }
	   
       keyboard.close();
    }
    
    private static void SortEmpleadosPorSalario(Empleado[] empleados)
    {
    	int size = empleados.length;
    	for (int i = 0; i < size - 1; i++)
    	      for (int j = 0; j < size - i - 1; j++)

    	        if (empleados[j].sueldoNeto() > empleados[j + 1].sueldoNeto()) {

    	          Empleado temp = empleados[j];
    	          empleados[j] = empleados[j + 1];
    	          empleados[j + 1] = temp;
    	        }
    }
    
    private static void SortEmpleadosPorRemuneracionExtra(Empleado[] empleados)
    {
    	int size = empleados.length;
    	for (int i = 0; i < size - 1; i++)
    	      for (int j = 0; j < size - i - 1; j++)

    	        if (empleados[j].calculoComplementoHorasExtras() > empleados[j + 1].calculoComplementoHorasExtras()) {

    	          Empleado temp = empleados[j];
    	          empleados[j] = empleados[j + 1];
    	          empleados[j + 1] = temp;
    	        }
    }
}
