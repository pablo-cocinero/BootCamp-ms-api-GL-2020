package hibernate.example.carrera;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CarreraDAOTest {

	static Carrera carrera;
	static CarreraDAO carreraDAO;
	
	@BeforeAll
	static void setUp() throws Exception {
		
		carrera = new Carrera();
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
		
		carreraDAO = new CarreraDAO();
		carreraDAO.createCarrera(carrera);
	}

	@Test
	@DisplayName("getCarrera_test")
	void testCase_1() {
		
		List<Carrera>  returnedCarrera = carreraDAO.getCarrera();
		assertEquals(carrera, returnedCarrera.get(0));
		
	}
	
	@Test
	@DisplayName("getCarreraById_test")
	void testCase_2() {
		
		List<Carrera>  returnedCarrera = carreraDAO.getCarrera(1);
		assertEquals(carrera, returnedCarrera.get(0));
		
	}
	
	@Test
	@DisplayName("updateCarrera_test")
	void testCase_3() {
		
		Carrera returnedCarrera = carreraDAO.getCarrera(1).get(0);
		returnedCarrera.setNombre("Carrera modificada");
		carreraDAO.updateCarrera(returnedCarrera);
		returnedCarrera = carreraDAO.getCarrera(1).get(0);
		assertNotEquals(carrera, returnedCarrera);
		assertEquals("Carrera modificada", returnedCarrera.getNombre());
	}
	
	@Test
	@DisplayName("removeCarrera_test")
	void testCase_4() {
		
		Carrera returnedCarrera = carreraDAO.getCarrera(1).get(0);
		int id = returnedCarrera.getId();
		carreraDAO.removeCarrera(returnedCarrera);
		
		assertTrue(!carreraDAO.getCarrera(id).contains(returnedCarrera));
		
	}

}
