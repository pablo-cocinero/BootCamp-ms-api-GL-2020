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

import com.globallogic.bootcampgl.model.Producto;
import com.globallogic.bootcampgl.service.ProductoService;

@RestController
public class ProductoController {

	ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping(value = "/productos/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id")Integer id){
		Producto producto = productoService.findById(id);
		return new ResponseEntity<>(producto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/productos")
	public ResponseEntity<Object> findAll(){
		List<Producto> producto = productoService.findAll();
		return new ResponseEntity<>(producto,HttpStatus.OK);
	}
	
	@PostMapping(value = "/productos")
	public ResponseEntity<Object> create(@RequestBody Producto libro){
		Producto createdProducto = productoService.create(libro);
		return new ResponseEntity<>(createdProducto,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/productos")
	public ResponseEntity<Object> update(@RequestBody Producto libro){
		Producto updatedProducto = productoService.update(libro);
		return new ResponseEntity<>(updatedProducto,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/productos/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id")Integer id){
		productoService.delete(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
}
