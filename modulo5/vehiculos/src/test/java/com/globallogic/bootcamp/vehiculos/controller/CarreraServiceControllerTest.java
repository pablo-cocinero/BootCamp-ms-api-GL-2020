package com.globallogic.bootcamp.vehiculos.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.globallogic.bootcamp.vehiculos.exceptions.ItemNotFound;
import com.globallogic.bootcamp.vehiculos.model.Carrera;
import com.globallogic.bootcamp.vehiculos.service.CarreraService;

@ExtendWith(MockitoExtension.class)
class CarreraServiceControllerTest {

	@Mock
	CarreraService carreraService;
	
	@InjectMocks
	CarreraController carreraController;
	
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
	@DisplayName("findAll")
	void testCase_01() {
		when(carreraService.findAll()).thenReturn(listCarrera);
		ResponseEntity<Object> responseEntity = carreraController.findAll();
		assertNotNull(responseEntity);
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),listCarrera);
	}

	
	@Test
	@DisplayName("getById")
	void testCase_02() {
		when(carreraService.getById("Desafio Ansilta")).thenReturn(carrera);
		ResponseEntity<Object> responseEntity = carreraController.getById("Desafio Ansilta");
		assertNotNull(responseEntity);
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),carrera);
	}
	
	@Test
	@DisplayName("create")
	void testCase_03() {
		when(carreraService.create(carrera)).thenReturn(carrera);
		ResponseEntity<Object> responseEntity = carreraController.create(carrera);
		assertNotNull(responseEntity);
		assertEquals(responseEntity.getStatusCodeValue(),201);
		assertEquals(responseEntity.getBody(),carrera);
	}
	
	@Test
	@DisplayName("update")
	void testCase_04() {
		when(carreraService.getById("Desafio Ansilta")).thenReturn(carrera);
		when(carreraService.update(carrera)).thenReturn(carrera);
		ResponseEntity<Object> responseEntity = carreraController.update("Desafio Ansilta",carrera);
		assertNotNull(responseEntity);
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),carrera);
	}
	
	@Test
	@DisplayName("delete")
	void testCase_05() {
		ResponseEntity<Object> responseEntity = carreraController.delete("Desafio Ansilta");
		assertNotNull(responseEntity);
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"Carrera Eliminada");
	}
	
	@Test
	@DisplayName("Exception Test")
	void testCase_06() {
		when(carreraService.getById("lnaledasd")).thenReturn(null);
		assertThatThrownBy(() -> {
			carreraController.getById("lnaledasd");
		}).isInstanceOf(ItemNotFound.class);
	}
	

}
