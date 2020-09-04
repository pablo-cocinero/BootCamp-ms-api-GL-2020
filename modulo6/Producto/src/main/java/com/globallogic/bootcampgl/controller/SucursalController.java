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

import com.globallogic.bootcampgl.model.Sucursal;
import com.globallogic.bootcampgl.service.SucursalService;

@RestController
public class SucursalController {

	SucursalService sucursalService;
	
	public SucursalController(SucursalService sucursalService) {
		this.sucursalService = sucursalService;
	}
	
	@GetMapping(value = "/sucursales/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id")Integer id){
		Sucursal sucursal = sucursalService.findById(id);
		return new ResponseEntity<>(sucursal,HttpStatus.OK);
	}
	
	@GetMapping(value = "/sucursales")
	public ResponseEntity<Object> findAll(){
		List<Sucursal> sucursal = sucursalService.findAll();
		return new ResponseEntity<>(sucursal,HttpStatus.OK);
	}
	
	@PostMapping(value = "/sucursales")
	public ResponseEntity<Object> create(@RequestBody Sucursal orden){
		Sucursal createdSucursal = sucursalService.create(orden);
		return new ResponseEntity<>(createdSucursal,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/sucursales")
	public ResponseEntity<Object> update(@RequestBody Sucursal orden){
		Sucursal updatedSucursal = sucursalService.update(orden);
		return new ResponseEntity<>(updatedSucursal,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/sucursales/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id")Integer id){
		sucursalService.delete(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
}
