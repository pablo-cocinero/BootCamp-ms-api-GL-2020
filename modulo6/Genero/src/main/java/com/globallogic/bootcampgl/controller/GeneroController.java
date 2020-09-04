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

import com.globallogic.bootcampgl.model.Genero;
import com.globallogic.bootcampgl.service.GeneroService;

@RestController
public class GeneroController {

	GeneroService generoService;
	
	public GeneroController(GeneroService generoService) {
		this.generoService = generoService;
	}
	
	@GetMapping(value = "/generos/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id")Integer id){
		Genero generos = generoService.findById(id);
		return new ResponseEntity<>(generos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/generos")
	public ResponseEntity<Object> findAll(){
		List<Genero> generos = generoService.findAll();
		return new ResponseEntity<>(generos,HttpStatus.OK);
	}
	
	@PostMapping(value = "/generos")
	public ResponseEntity<Object> create(@RequestBody Genero libro){
		Genero createdGenero = generoService.create(libro);
		return new ResponseEntity<>(createdGenero,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/generos")
	public ResponseEntity<Object> update(@RequestBody Genero libro){
		Genero updatedGenero = generoService.update(libro);
		return new ResponseEntity<>(updatedGenero,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/generos/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id")Integer id){
		generoService.delete(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
}
