package com.globallogic.bootcamp.vehiculos.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcamp.vehiculos.model.Modelo;
import com.globallogic.bootcamp.vehiculos.repository.ModeloRepository;

@Service
public class ModeloService {

private ModeloRepository modeloRepository;
	
	public ModeloService(ModeloRepository modeloRepository)
	{
		this.modeloRepository = modeloRepository;
	}
	public Modelo create(Modelo modelo) {
		return modeloRepository.save(modelo);
	}
	
	public Modelo getById(Integer id) {
		
		if (isNull(id))	return null;

		Optional<Modelo> modelo = modeloRepository.findById(id);

		if (modelo.isPresent())
			return modelo.get();
		else
			return null;
	}
	
	public List<Modelo> findAll(){
		return modeloRepository.findAll();
	}
	
	public Modelo update(Modelo modelo) {

		return modeloRepository.save(modelo);
	}
	
	public void delete(Integer id) {

		if (nonNull(id)) {
			
			Optional<Modelo> modelo = modeloRepository.findById(id);

			if (modelo.isPresent()) 
				modeloRepository.delete(modelo.get());	
		}
	}
}
