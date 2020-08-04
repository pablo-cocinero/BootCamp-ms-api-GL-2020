package coverage.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coverage.example.model.Planet;
import coverage.example.model.Star;

class ApplicationTest {

	Application App = new Application();
	private Star star;
	private Planet planet;
	private List<Planet> planets;
	
	@BeforeEach
	void setUp() {
		star = new Star();
		star.setName("Sol");
		star.setColor("Naranja");
		planet = new Planet();
		planet.setName("Tierra");
		planets = new ArrayList<Planet>();
		planets.add(planet);
		star.setPlanets(planets);
		
	}
	
	@Test
	void testMain() {
		Application.main(null);
	}
		
	@Test
	@DisplayName("Test Star getName")
	void testStarName() {
		assertEquals("Sol",star.getName());
	}
	
	@Test
	@DisplayName("Test Star getColor")
	void testStarColor() {
		assertEquals("Naranja",star.getColor());
	}
	
	@Test
	@DisplayName("Test Star getPlanets")
	void testStarPlanets() {
		assertEquals(planets.get(0).getName(),star.getPlanets().get(0).getName());
	}
	
	@Test
	@DisplayName("Test Star ToString")
	void testStarToString() {
		assertEquals("Star [name=Sol, planets=[Planet [name=Tierra]]]",star.toString());
	}

}
