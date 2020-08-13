package hibernate.example;

public class ExampleApplication {

	public static void main(String[] args) {
		
		Alumno alumno1 =  new Alumno(1,"Jose","Perez"); 
		Alumno alumno2 =  new Alumno(2,"Esteban","Quito"); 
		Alumno alumno3 =  new Alumno(3,"Ulrica","Godofreda"); 
		
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		
		alumnoDAO.createAlumno(alumno1);
		alumnoDAO.createAlumno(alumno2);
		alumnoDAO.createAlumno(alumno3);
		
		System.out.println("Alumnos creados");
		
		System.out.println(alumnoDAO.getAlumnos()); 
		
		alumno2.setNombre("Estefano");
		alumnoDAO.updateAlumno(alumno2);
		
		System.out.println("Alumnos con modificacion de Esteban");
		
		System.out.println(alumnoDAO.getAlumnos()); 
		
		alumnoDAO.removeAlumno(alumno1);

		System.out.println("Alumnos sin Jose");
		
		System.out.println(alumnoDAO.getAlumnos()); 
		
	}

}
