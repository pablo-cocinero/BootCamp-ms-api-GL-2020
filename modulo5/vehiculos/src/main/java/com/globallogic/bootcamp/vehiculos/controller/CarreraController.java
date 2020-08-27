package com.globallogic.bootcamp.vehiculos.controller;

import static java.util.Objects.isNull;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcamp.vehiculos.exceptions.ItemNotFound;
import com.globallogic.bootcamp.vehiculos.model.Carrera;
import com.globallogic.bootcamp.vehiculos.service.CarreraService;
import static java.util.Objects.nonNull;
@RestController
public class CarreraController {

private CarreraService carreraService;
	
	public CarreraController(CarreraService carreraService) {
		this.carreraService = carreraService;
	}
	
	@GetMapping(value = "/carreras")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(carreraService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/carreras/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") String id) {
		Carrera carreraResponse = carreraService.getById(id);
		if(nonNull(carreraResponse))
		return new ResponseEntity<>(carreraResponse, HttpStatus.OK);
		else
			throw new ItemNotFound();
	}
	
	@PostMapping(value = "/carreras")
	public ResponseEntity<Object> create(@Valid @RequestBody Carrera carrera) {
		return new ResponseEntity<>(carreraService.create(carrera),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/carreras/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") String id, @Valid @RequestBody Carrera carrera) {
		Carrera carreraResponse;
		if (isNull(carreraService.getById(id))) {
			 carreraResponse = carreraService.create(carrera);
		} else {
			 carreraResponse = carreraService.update(carrera);
		}
		return new ResponseEntity<>(carreraResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/carreras/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") String id) {
		carreraService.delete(id);
		return new ResponseEntity<>("Carrera Eliminada", HttpStatus.OK);
	}
	
}
