package com.globallogic.bootcampgl.controller;

import static java.util.Objects.isNull;

import org.springframework.hateoas.mvc.BasicLinkBuilder;

import java.util.List;

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

import com.globallogic.bootcampgl.model.Cliente;
import com.globallogic.bootcampgl.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "Client API")
public class ClienteController {

private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	@ApiOperation(value = "return all clients", response = Cliente.class, responseContainer = "List")
	@GetMapping(value = "/clientes")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(clienteService.findAll(),HttpStatus.OK);
	}
	@ApiOperation(value = "return a single client by id", response = Cliente.class)
	@GetMapping(value = "/clientes/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") Integer id) {
		Cliente clienteResponse = clienteService.findById(id);
		return new ResponseEntity<>(addLinkSurname(addLinkEmail(clienteResponse)), HttpStatus.OK);
	}
	@ApiOperation(value = "return a single client by surname", response = Cliente.class)
	@GetMapping(value = "/clientes/apellido/{apellido}")
	public ResponseEntity<Object> getBySurname(@PathVariable(name = "apellido") String apellido) {
		List<Cliente> clienteResponse = clienteService.findBySurname(apellido);
		return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
	}
	@ApiOperation(value = "return a single client by email", response = Cliente.class)
	@GetMapping(value = "/clientes/correo/{correo}")
	public ResponseEntity<Object> getByEmail(@PathVariable(name = "correo") String correo) {
		List<Cliente> vehiculoResponse = clienteService.findByEmail(correo);
		return new ResponseEntity<>(vehiculoResponse, HttpStatus.OK);
	}
	@ApiOperation(value = "create a client", response = Cliente.class)
	@PostMapping(value = "/clientes")
	public ResponseEntity<Object> create(@Valid @RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.create(cliente),HttpStatus.CREATED);
	}
	@ApiOperation(value = "update a client by id", response = Cliente.class)
	@PutMapping(value = "/clientes/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Integer id, @Valid @RequestBody Cliente cliente) {
		Cliente clienteResponse;
		if (isNull(clienteService.findById(id))) {
			clienteResponse = clienteService.create(cliente);
		} else {
			clienteResponse = clienteService.update(cliente);
		}
		return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
	}
	@ApiOperation(value = "delete a client", response = Cliente.class)
	@DeleteMapping(value = "/clientes/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
		clienteService.delete(id);
		return new ResponseEntity<>("Cliente Eliminado", HttpStatus.OK);
	}
	
	private Cliente addLinkEmail(Cliente cliente) {
		cliente.add(BasicLinkBuilder.linkToCurrentMapping()
				.slash("clientes")
				.slash("correo")
	            .slash(cliente.getCorreo()).withSelfRel());
		return cliente;
	}
	private Cliente addLinkSurname(Cliente cliente) {
		cliente.add(BasicLinkBuilder.linkToCurrentMapping()
				.slash("clientes")
				.slash("apellido")
	            .slash(cliente.getApellido()).withSelfRel());
		return cliente;
	}
}
