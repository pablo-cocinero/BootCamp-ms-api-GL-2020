package coverage.loteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coverage.loteria.model.CartonGenerator;

class LoteriaTest {

	private Loteria loteria;
	
	@BeforeEach
	void setUp()
	{
		loteria = new Loteria(1000000f, 1000, new CartonGenerator());
	}
	
	@Test
	@DisplayName("getPozo")
	void testPozo() {
		assertEquals(1000000f,loteria.getPozo());
	}
	
	@Test
	@DisplayName("getBoletos")
	void testBoletos() {
		assertEquals(1000,loteria.getBoletos());
	}

	@Test
	@DisplayName("getGanadores")
	void testGanadores() {
		loteria.jugada();
		assertEquals(0,loteria.getGanadores());
	}
	
	@Test
	@DisplayName("get Numero de Ganadores")
	void testNumGanadores() {
		assertFalse(loteria.hayGanadorUnico());
		assertFalse(loteria.hayCuadrupleGanador());
	}
	
	//La forma de cubrir el 100% del código con test es usando instancias mock, para generar el caso ganador
	
}
