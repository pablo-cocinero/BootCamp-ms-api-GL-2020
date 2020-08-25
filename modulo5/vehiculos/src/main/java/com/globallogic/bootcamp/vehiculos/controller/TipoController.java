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

import com.globallogic.bootcamp.vehiculos.model.Tipo;
import com.globallogic.bootcamp.vehiculos.service.TipoService;

@RestController
public class TipoController {

private TipoService tipoService;
	
	public TipoController(TipoService tipoService) {
		this.tipoService = tipoService;
	}
	
	@GetMapping(value = "/tipos")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(tipoService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/tipos/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(tipoService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/tipos")
	public ResponseEntity<Object> create(@Valid @RequestBody Tipo tipo) {
		return new ResponseEntity<>(tipoService.create(tipo),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/tipos/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody Tipo tipo) {
		Tipo tipoResponse;
		if (isNull(tipoService.getById(id))) {
			 tipoResponse = tipoService.create(tipo);
		} else {
			 tipoResponse = tipoService.update(tipo);
		}
		return new ResponseEntity<>(tipoResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/tipos/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
		tipoService.delete(id);
		return new ResponseEntity<>("Tipo Eliminado", HttpStatus.OK);
	}
	
}
