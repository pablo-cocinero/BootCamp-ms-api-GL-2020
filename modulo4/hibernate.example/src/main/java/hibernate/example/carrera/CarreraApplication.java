package hibernate.example.carrera;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class CarreraApplication {

	public static void main(String[] args) {
		
		Carrera carrera = new Carrera();
		carrera.setNombre("Gran Carrera Golbal");
		carrera.setFecha(Date.valueOf(LocalDate.now()));
		
		ArrayList<Competidor> competidores = new ArrayList<Competidor>();
		Competidor competidor1 = new Competidor(); competidor1.setNombre("Sebastian Loeb"); competidor1.setCarrera(carrera);
		Competidor competidor2 = new Competidor(); competidor2.setNombre("Marcus Gronholm"); competidor2.setCarrera(carrera);
		Competidor competidor3 = new Competidor(); competidor3.setNombre("Carlos Sainz"); competidor3.setCarrera(carrera);
		Competidor competidor4 = new Competidor(); competidor4.setNombre("Petter Solberg"); competidor4.setCarrera(carrera);
		
		competidores.add(competidor1);
		competidores.add(competidor2);
		competidores.add(competidor3);
		competidores.add(competidor4);
		
		carrera.setCompetidores(competidores);
		
		CarreraDAO carreraDAO = new CarreraDAO();
		carreraDAO.createCarrera(carrera);
		System.out.println("Creando carrera...");
		
		System.out.println(carreraDAO.getCarrera());
	}

}
