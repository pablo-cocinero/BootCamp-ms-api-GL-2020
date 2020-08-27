package com.globallogic.bootcamp.vehiculos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globallogic.bootcamp.vehiculos.model.Carrera;
import com.globallogic.bootcamp.vehiculos.model.Vehiculo;
import com.globallogic.bootcamp.vehiculos.repository.CarreraRepository;

@ExtendWith(MockitoExtension.class)
class CarreraServiceTest {

	@Mock 
	CarreraRepository carreraRepository;
	
	@InjectMocks
	CarreraService carreraService;
	
	Carrera carrera;
	Optional<Carrera> carreraO;
	List<Carrera> listCarrera;
	
	@BeforeEach
	void setUp() throws Exception {
	carrera = new Carrera();
	carrera.setNombre("Desafio Ansilta");
	carreraO = Optional.of(carrera);
	listCarrera = new ArrayList<>();
	listCarrera.add(carrera);
	}

	@Test
	void testCase_01() {
		when(carreraRepository.save(carrera)).thenReturn(carrera);
		Carrera carreraResponse = carreraService.create(carrera);
		assertNotNull(carreraResponse);
		assertEquals(carreraResponse,carrera);
	}

	@Test
	void testCase_02() {
		when(carreraRepository.findById("Desafio Ansilta")).thenReturn(carreraO);
		Carrera carreraResponse = carreraService.getById("Desafio Ansilta");
		assertNotNull(carreraResponse);
		assertEquals(carreraResponse,carreraO.get());
	}
	
	@Test
	void testCase_03() {
		when(carreraRepository.findAll()).thenReturn(listCarrera);
		List<Carrera> listCarreraResponse = carreraService.findAll();
		assertNotNull(listCarreraResponse);
		assertEquals(listCarreraResponse, listCarrera);
	}
	
	@Test
	void testCase_04() {
		when(carreraRepository.save(carrera)).thenReturn(carrera);
		Carrera carreraResponse = carreraService.update(carrera);
		assertNotNull(carreraResponse);
		assertEquals(carreraResponse,carrera);
	}
	
	@Test
	void testCase_05() {
		when(carreraRepository.findById("Desafio Ansilta")).thenReturn(carreraO);
		carreraService.delete("Desafio Ansilta");
	}
	
	@ParameterizedTest
	@MethodSource("carreras")
	public void testCase_06(Carrera carrera)
	{
		Optional<Carrera> carreraOpt = Optional.of(carrera);
		when(carreraRepository.findById(carrera.getNombre())).thenReturn(carreraOpt);
		Carrera carreraResponse = carreraService.getById(carrera.getNombre());
		assertNotNull(carreraResponse);
		assertEquals(carreraResponse,carreraOpt.get());
	}
	
	private static Stream<Carrera> carreras(){
		Carrera carrera2 = new Carrera();
		carrera2.setNombre("42k");
		Carrera carrera3 = new Carrera();
		carrera3.setNombre("Calingasta");
		Carrera carrera4 = new Carrera();
		carrera4.setNombre("Interlagos");
		return Stream.of(carrera2,carrera3,carrera4);
	}
	
}
