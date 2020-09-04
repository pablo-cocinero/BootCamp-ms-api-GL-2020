package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Compra;
import com.globallogic.bootcampgl.repository.CompraRepository;

@Service
public class CompraService {

	CompraRepository compraRepository;
	
	public CompraService(CompraRepository compraRepository) {
		this.compraRepository = compraRepository;
	}
	
	public Compra create(Compra compra) {
		return compraRepository.save(compra);
	}
	
	public Compra findById(Integer id) {
		 Optional<Compra> optCompra = compraRepository.findById(id);
		 if(optCompra.isPresent())
		 return optCompra.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Compra> findAll(){
		return compraRepository.findAll();
	}
	
	public Compra update(Compra compra) {
		
		Compra Old = findById(compra.getId());
		compraRepository.delete(Old);
		return compraRepository.save(compra);
	}
	
	public void delete(Integer id) {
		Compra toDelete = findById(id);
		compraRepository.delete(toDelete);
	}
}
