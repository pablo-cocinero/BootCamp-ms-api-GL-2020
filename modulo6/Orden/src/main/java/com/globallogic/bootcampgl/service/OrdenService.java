package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Compra;
import com.globallogic.bootcampgl.model.Orden;
import com.globallogic.bootcampgl.repository.CompraRepository;
import com.globallogic.bootcampgl.repository.OrdenRepository;

@Service
public class OrdenService {

	OrdenRepository ordenRepository;
	CompraRepository compraRepository;
	
	public OrdenService(OrdenRepository ordenRepository,CompraRepository compraRepository) {
		this.ordenRepository = ordenRepository;
		this.compraRepository = compraRepository;
	}
	
	public Orden create(Orden orden) {
		List<Compra> compras = orden.getListaCompra();
		for(Compra compra : compras)
		compraRepository.save(compra);
		return ordenRepository.save(orden);
	}
	
	public Orden findById(Integer id) {
		 Optional<Orden> optOrden = ordenRepository.findById(id);
		 if(optOrden.isPresent())
		 return optOrden.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Orden> findAll(){
		return ordenRepository.findAll();
	}
	
	public Orden update(Orden orden) {
		
		Orden Old = findById(orden.getId());
		ordenRepository.delete(Old);
		return ordenRepository.save(orden);
	}
	
	public void delete(Integer id) {
		Orden toDelete = findById(id);
		ordenRepository.delete(toDelete);
	}
}
