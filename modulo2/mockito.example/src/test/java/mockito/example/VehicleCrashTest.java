package mockito.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import mockito.example.model.Vehicle;

@ExtendWith(MockitoExtension.class)
public class VehicleCrashTest {

	

	@InjectMocks
	static VehicleCrash crashMock = new VehicleCrash();
	
	Vehicle vehicle = mock(Vehicle.class);
	Vehicle vehicle1 = mock(Vehicle.class);
	
	@Test
	public void WhenNoCrashNoValueThenOk() {
		VehicleCrash crashTest = new VehicleCrash();
		
		assertEquals(0, crashTest.getTotalEnergy());
		assertEquals(0, crashTest.getTotalVehicles());
		assertEquals("No crashes measured",crashTest.toString());
	}

	@Test
	public void WhenCrashAndCorrectValueThenOk() {
		
		when(vehicle.getMass()).thenReturn(10.0);
		when(vehicle.getMaxSpeed()).thenReturn(5.0);
		
		when(vehicle1.getMass()).thenReturn(10.0);
		when(vehicle1.getMaxSpeed()).thenReturn(5.0);
		
		crashMock.crash(vehicle);
 		crashMock.crash(vehicle1);
		
		assertEquals(250.0, crashMock.getTotalEnergy());
		assertEquals(2, crashMock.getTotalVehicles());
		assertEquals("Up to 250.0 Joules in 2 crashes measured",crashMock.toString());
	}

}
