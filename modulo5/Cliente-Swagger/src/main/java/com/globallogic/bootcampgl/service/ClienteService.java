package com.globallogic.bootcampgl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Cliente;
import com.globallogic.bootcampgl.repository.ClienteRepository;

@Service
public class ClienteService {

	ClienteRepository clienteRepository = new ClienteRepository();

	public Cliente create(Cliente cliente) {
		if (clienteRepository.getClientes().add(cliente))
			return cliente;
		else
			return null;
	}

	public Cliente findById(Integer dni) {
		return clienteRepository.findById(dni);
	}

	public void delete(int dni) {
		Cliente cliente = findById(dni);
		clienteRepository.getClientes().remove(cliente);
	}

	public Cliente update(Cliente cliente) {
		Cliente clienteRepo = findById(cliente.getDNI());
		clienteRepository.getClientes().remove(clienteRepo);
		return create(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.getClientes();
	}

	public List<Cliente> findBySurname(String apellido) {
		ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
		for(Cliente c : clienteRepository.getClientes())
			if(c.getApellido().equals(apellido))
				listCliente.add(c);
		return listCliente;
	}

	public List<Cliente> findByEmail(String correo) {

		ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
		for(Cliente c : clienteRepository.getClientes())
			if(c.getCorreo().equals(correo))
				listCliente.add(c);
		return listCliente;
	}
}
