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

import com.globallogic.bootcampgl.model.Libro;
import com.globallogic.bootcampgl.service.LibroService;

@RestController
public class LibroController {

	LibroService libroService;
	
	public LibroController(LibroService libroService) {
		this.libroService = libroService;
	}
	
	@GetMapping(value = "/libros/{isbn}")
	public ResponseEntity<Object> findById(@PathVariable(name = "isbn")Long id){
		Libro libro = libroService.findById(id);
		return new ResponseEntity<>(libro,HttpStatus.OK);
	}
	
	@GetMapping(value = "/libros")
	public ResponseEntity<Object> findAll(){
		List<Libro> libros = libroService.findAll();
		return new ResponseEntity<>(libros,HttpStatus.OK);
	}
	
	@PostMapping(value = "/libros")
	public ResponseEntity<Object> create(@RequestBody Libro libro){
		Libro Createdlibro = libroService.create(libro);
		return new ResponseEntity<>(Createdlibro,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/libros")
	public ResponseEntity<Object> update(@RequestBody Libro libro){
		Libro updatedLibro = libroService.update(libro);
		return new ResponseEntity<>(updatedLibro,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/libros/{isbn}")
	public ResponseEntity<Object> update(@PathVariable(name = "isbn")Long id){
		libroService.delete(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
}
