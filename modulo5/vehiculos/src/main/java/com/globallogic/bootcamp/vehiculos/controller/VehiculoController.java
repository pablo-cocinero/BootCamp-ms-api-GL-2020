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

import com.globallogic.bootcamp.vehiculos.model.Vehiculo;
import com.globallogic.bootcamp.vehiculos.service.VehiculoService;

@RestController
public class VehiculoController {

	private VehiculoService vehiculoService;
	
	public VehiculoController(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}
	
	@GetMapping(value = "/vehiculos")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(vehiculoService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/vehiculos/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(vehiculoService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/vehiculos")
	public ResponseEntity<Object> create(@Valid @RequestBody Vehiculo vehiculo) {
		return new ResponseEntity<>(vehiculoService.create(vehiculo),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/vehiculos/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody Vehiculo vehiculo) {
		Vehiculo vehiculoResponse;
		if (isNull(vehiculoService.getById(id))) {
			 vehiculoResponse = vehiculoService.create(vehiculo);
		} else {
			 vehiculoResponse = vehiculoService.update(vehiculo);
		}
		return new ResponseEntity<>(vehiculoResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/vehiculos/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
		vehiculoService.delete(id);
		return new ResponseEntity<>("Vehiculo Eliminado", HttpStatus.OK);
	}
}
