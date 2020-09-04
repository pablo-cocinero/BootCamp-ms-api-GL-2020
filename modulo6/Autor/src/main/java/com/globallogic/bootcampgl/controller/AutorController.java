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

import com.globallogic.bootcampgl.model.Autor;
import com.globallogic.bootcampgl.service.AutorService;

@RestController
public class AutorController {

	AutorService autorService;
	
	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}
	
	@GetMapping(value = "/autores/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id")Integer id){
		Autor libro = autorService.findById(id);
		return new ResponseEntity<>(libro,HttpStatus.OK);
	}
	
	@GetMapping(value = "/autores")
	public ResponseEntity<Object> findAll(){
		List<Autor> libros = autorService.findAll();
		return new ResponseEntity<>(libros,HttpStatus.OK);
	}
	
	@PostMapping(value = "/autores")
	public ResponseEntity<Object> create(@RequestBody Autor libro){
		Autor Createdlibro = autorService.create(libro);
		return new ResponseEntity<>(Createdlibro,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/autores")
	public ResponseEntity<Object> update(@RequestBody Autor libro){
		Autor updatedLibro = autorService.update(libro);
		return new ResponseEntity<>(updatedLibro,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/autores/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id")Integer id){
		autorService.delete(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
}
