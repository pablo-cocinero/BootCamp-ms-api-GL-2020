package com.globallogic.bootcamp.vehiculos.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globallogic.bootcamp.vehiculos.model.Carrera;
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
		assertNotNull(carreraService.create(carrera));
	}

	@Test
	void testCase_02() {
		when(carreraRepository.findById("Desafio Ansilta")).thenReturn(carreraO);
		assertNotNull(carreraService.getById("Desafio Ansilta"));
	}
	
	@Test
	void testCase_03() {
		when(carreraRepository.findAll()).thenReturn(listCarrera);
		assertNotNull(carreraService.findAll());
	}
	
	@Test
	void testCase_04() {
		when(carreraRepository.save(carrera)).thenReturn(carrera);
		assertNotNull(carreraService.update(carrera));
	}
	
	@Test
	void testCase_05() {
		when(carreraRepository.findById("Desafio Ansilta")).thenReturn(carreraO);
		carreraService.delete("Desafio Ansilta");
	}
}
