package com.globallogic.bootcamp.vehiculos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.bootcamp.vehiculos.service.VehiculoServiceTest;


public class VehiculosApplicationTests {

	@Test
	public void contextLoads() {
		VehiculoServiceTest vehiculoServiceTest = new VehiculoServiceTest();
	}

}
