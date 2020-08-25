package com.globallogic.bootcamp.vehiculos.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcamp.vehiculos.model.Tipo;
import com.globallogic.bootcamp.vehiculos.repository.TipoRepository;

@Service
public class TipoService {

private TipoRepository tipoRepository;
	
	public TipoService(TipoRepository tipoRepository)
	{
		this.tipoRepository = tipoRepository;
	}
	
	public Tipo create(Tipo tipo) {
		return tipoRepository.save(tipo);
	}
	
	public Tipo getById(Integer id) {
		
		if (isNull(id))	return null;

		Optional<Tipo> tipo = tipoRepository.findById(id);

		if (tipo.isPresent())
			return tipo.get();
		else
			return null;
	}
	
	public List<Tipo> findAll(){
		return tipoRepository.findAll();
	}
	
	public Tipo update(Tipo tipo) {

		return tipoRepository.save(tipo);
	}
	
	public void delete(Integer id) {

		if (nonNull(id)) {
			
			Optional<Tipo> tipo = tipoRepository.findById(id);

			if (tipo.isPresent()) 
				tipoRepository.delete(tipo.get());	
		}
	}
}
