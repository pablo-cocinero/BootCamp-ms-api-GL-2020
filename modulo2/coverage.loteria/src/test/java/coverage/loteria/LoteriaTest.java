package coverage.loteria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import coverage.loteria.model.CartonGenerator;

@ExtendWith(MockitoExtension.class)
class LoteriaTest {

	Loteria loteria;
	@Mock
	private CartonGenerator cartonMock; 
	
	@InjectMocks
	private CartonGenerator cartonInjectMocks; 
	
	@Mock
	private static Random random;
	
	@Test
	@DisplayName("sin jugar")
	void test_sinJugar()
	{
		loteria = new Loteria(50000,1000,new CartonGenerator());
		assertEquals(50000,loteria.getPozo());
		assertEquals(1000,loteria.getBoletos());
		assertEquals(0,loteria.getGanadores());
		assertFalse(loteria.hayGanadorUnico());
		assertFalse(loteria.hayCuadrupleGanador());
	}
	
	@Test
	@DisplayName("jugada normal")
	void test_jugadaNormal()
	{
		loteria = new Loteria(50000,1000,new CartonGenerator());
		loteria.jugada();
		assertEquals(50000,loteria.getPozo());
		assertEquals(1000,loteria.getBoletos());
		assertEquals(0,loteria.getGanadores());
		assertFalse(loteria.hayGanadorUnico());
		assertFalse(loteria.hayCuadrupleGanador());
	}
	
	@Test
	@DisplayName("un ganador")
	void test_unGanador()
	{
		when(cartonMock.isGanador()).thenReturn(true, false);
		
		loteria = new Loteria(50000,1000,cartonMock);
		loteria.jugada();
		assertEquals(50000,loteria.getPozo());
		assertEquals(1000,loteria.getBoletos());
		assertEquals(1,loteria.getGanadores());
		assertTrue(loteria.hayGanadorUnico());
		assertFalse(loteria.hayCuadrupleGanador());
	}
	
	@Test
	@DisplayName("cuatro ganador")
	void test_cuatroGanadores()
	{
		when(random.nextInt()).thenReturn(1, 1, 1 , 1, 0);
		
		loteria = new Loteria(50000,1000,cartonInjectMocks);
		loteria.jugada();
		assertEquals(50000,loteria.getPozo());
		assertEquals(1000,loteria.getBoletos());
		assertEquals(4,loteria.getGanadores());
		assertFalse(loteria.hayGanadorUnico());
		assertTrue(loteria.hayCuadrupleGanador());
	}
	
}
