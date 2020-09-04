package com.globallogic.bootcampgl.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.model.Orden;
import com.globallogic.bootcampgl.service.OrdenService;

@RestController
public class OrdenController {

	OrdenService ordenService;
	
	public OrdenController(OrdenService ordenService) {
		this.ordenService = ordenService;
	}
	
	@GetMapping(value = "/ordenes/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id")Integer id){
		Orden orden = ordenService.findById(id);
		return new ResponseEntity<>(orden,HttpStatus.OK);
	}
	
	@GetMapping(value = "/ordenes")
	public ResponseEntity<Object> findAll(){
		List<Orden> ordenes = ordenService.findAll();
		return new ResponseEntity<>(ordenes,HttpStatus.OK);
	}
	
	@PostMapping(value = "/ordenes")
	public ResponseEntity<Object> create(@RequestBody Orden orden){
		Orden createdOrden = ordenService.create(orden);
		return new ResponseEntity<>(createdOrden,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/ordenes")
	public ResponseEntity<Object> update(@RequestBody Orden orden){
		Orden updatedLibro = ordenService.update(orden);
		return new ResponseEntity<>(updatedLibro,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/ordenes/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id")Integer id){
		ordenService.delete(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
}
