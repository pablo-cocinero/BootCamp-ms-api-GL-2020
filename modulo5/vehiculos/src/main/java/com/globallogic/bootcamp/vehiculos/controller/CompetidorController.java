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

import com.globallogic.bootcamp.vehiculos.model.Competidor;
import com.globallogic.bootcamp.vehiculos.service.CompetidorService;

@RestController
public class CompetidorController {

private CompetidorService competidorService;
	
	public CompetidorController(CompetidorService competidorService) {
		this.competidorService = competidorService;
	}
	
	@GetMapping(value = "/competidores")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(competidorService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/competidores/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(competidorService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/competidores")
	public ResponseEntity<Object> create(@Valid @RequestBody Competidor competidor) {
		return new ResponseEntity<>(competidorService.create(competidor),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/competidores/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody Competidor competidor) {
		Competidor competidorResponse;
		if (isNull(competidorService.getById(id))) {
			 competidorResponse = competidorService.create(competidor);
		} else {
			 competidorResponse = competidorService.update(competidor);
		}
		return new ResponseEntity<>(competidorResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/competidores/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
		competidorService.delete(id);
		return new ResponseEntity<>("Competidor Eliminado", HttpStatus.OK);
	}
}
