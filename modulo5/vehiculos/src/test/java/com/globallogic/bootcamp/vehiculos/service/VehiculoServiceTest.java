package com.globallogic.bootcamp.vehiculos.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globallogic.bootcamp.vehiculos.model.Modelo;
import com.globallogic.bootcamp.vehiculos.model.Tipo;
import com.globallogic.bootcamp.vehiculos.model.Vehiculo;
import com.globallogic.bootcamp.vehiculos.repository.VehiculoRepository;


@ExtendWith(MockitoExtension.class)
public class VehiculoServiceTest {

	@Mock
	VehiculoRepository vehiculoRepository;

	@InjectMocks
	VehiculoService vehiculoService;

	Vehiculo vehiculo1;
	Optional<Vehiculo> vehiculoO;
	List<Vehiculo> ListVehiculo;
	Modelo modelo1;
	Tipo tipo1;
	
	@BeforeEach
	public void setup() {
		vehiculo1 = new Vehiculo();
		modelo1 = new Modelo();
		tipo1 = new Tipo();
		modelo1.setCodigo(1);
		modelo1.setMarca("ford");
		modelo1.setNombre("focus");
		tipo1.setCodigo(1);
		tipo1.setPuertas(5);
		tipo1.setCategoria("sedan");
		vehiculo1.setCodigo(34);
		vehiculo1.setFechaProduccion(new Date());
		vehiculo1.setIdentificacion("ABC-123");
		vehiculo1.setModelo(modelo1);
		vehiculo1.setTipo(tipo1);
		vehiculoO = Optional.of(vehiculo1);
		ListVehiculo = new ArrayList<>();
		ListVehiculo.add(vehiculo1);
	}
	
	@Test
	public void testCase_01() {
		when(vehiculoRepository.save(vehiculo1)).thenReturn(vehiculo1);
		Vehiculo vehiculoResponse = vehiculoService.create(vehiculo1);
		assertNotNull(vehiculoResponse);
		assertEquals(vehiculoResponse,vehiculo1);
		assertTrue(vehiculoResponse.equals(vehiculo1));
	}
	
	@Test
	public void testCase_02() {
		when(vehiculoRepository.findById(34)).thenReturn(vehiculoO);
		Vehiculo vehiculoResponse = vehiculoService.getById(34);
		assertNotNull(vehiculoResponse);
		assertEquals(vehiculoResponse,vehiculo1);
	}

	@Test
	public void testCase_03() {
		when(vehiculoRepository.findAll()).thenReturn(ListVehiculo);
		assertNotNull(vehiculoService.findAll());
		assertEquals(vehiculoService.findAll(),ListVehiculo);
	}
	
	@Test
	public void testCase_04() {
		when(vehiculoRepository.save(vehiculo1)).thenReturn(vehiculo1);
		assertNotNull(vehiculoService.update(vehiculo1));
		assertEquals(vehiculoService.update(vehiculo1),vehiculo1);
	}
	
	@ParameterizedTest
	@MethodSource("vehiculos")
	public void testCase_05(Vehiculo vehiculo)
	{
		Optional<Vehiculo> vehiculoOpt = Optional.of(vehiculo);
		when(vehiculoRepository.findById(vehiculo.getCodigo())).thenReturn(vehiculoOpt);
		Vehiculo vehiculoResponse = vehiculoService.getById(vehiculo.getCodigo());
		assertNotNull(vehiculoResponse);
		assertEquals(vehiculoResponse,vehiculoOpt.get());
	}
	
	private static Stream<Vehiculo> vehiculos(){
		Vehiculo vehiculo2 = new Vehiculo();
		vehiculo2.setCodigo(56);
		Vehiculo vehiculo3 = new Vehiculo();
		vehiculo3.setCodigo(99);
		Vehiculo vehiculo4 = new Vehiculo();
		vehiculo4.setCodigo(78);
		return Stream.of(vehiculo2,vehiculo3,vehiculo4);
	}
}
