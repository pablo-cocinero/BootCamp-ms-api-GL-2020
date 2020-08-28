package com.globallogic.bootcampgl.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Cliente;

import lombok.Data;

@Repository
@Data
public class ClienteRepository {

	List<Cliente> Clientes;
	
	@Autowired
	public ClienteRepository() {
		Clientes = new ArrayList<Cliente>();
	}
	
	public Cliente findById(int dni) {
		for(Cliente c : Clientes)
			if(c.getDNI().equals(dni))
				return c;
		return null;
	}
}
