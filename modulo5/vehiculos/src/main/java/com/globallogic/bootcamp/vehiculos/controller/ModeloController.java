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

import com.globallogic.bootcamp.vehiculos.model.Modelo;
import com.globallogic.bootcamp.vehiculos.service.ModeloService;

@RestController
public class ModeloController {

private ModeloService modeloService;
	
	public ModeloController(ModeloService modeloService) {
		this.modeloService = modeloService;
	}
	
	@GetMapping(value = "/modelos")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(modeloService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/modelos/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(modeloService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/modelos")
	public ResponseEntity<Object> create(@Valid @RequestBody Modelo modelo) {
		return new ResponseEntity<>(modeloService.create(modelo),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/modelos/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody Modelo modelo) {
		Modelo modeloResponse;
		if (isNull(modeloService.getById(id))) {
			 modeloResponse = modeloService.create(modelo);
		} else {
			 modeloResponse = modeloService.update(modelo);
		}
		return new ResponseEntity<>(modeloResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/modelos/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
		modeloService.delete(id);
		return new ResponseEntity<>("Nodelo Eliminado", HttpStatus.OK);
	}
	
}
