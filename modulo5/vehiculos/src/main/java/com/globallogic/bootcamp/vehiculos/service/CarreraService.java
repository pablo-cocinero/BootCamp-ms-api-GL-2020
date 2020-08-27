package com.globallogic.bootcamp.vehiculos.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcamp.vehiculos.exceptions.ItemNotFound;
import com.globallogic.bootcamp.vehiculos.model.Carrera;
import com.globallogic.bootcamp.vehiculos.repository.CarreraRepository;

@Service
public class CarreraService {

private CarreraRepository carreraRepository;
	
	public CarreraService(CarreraRepository carreraRepository)
	{
		this.carreraRepository = carreraRepository;
	}
	
	public Carrera create(Carrera carrera) {
		return carreraRepository.save(carrera);
	}
	
	public Carrera getById(String id) {
		
		if (isNull(id))	return null;

		Optional<Carrera> carrera = carreraRepository.findById(id);

		if (carrera.isPresent())
			return carrera.get();
		else
			throw new ItemNotFound();
	}
	
	public List<Carrera> findAll(){
		return carreraRepository.findAll();
	}
	
	public Carrera update(Carrera carrera) {

		return carreraRepository.save(carrera);
	}
	
	public void delete(String id) {

		if (nonNull(id)) {
			
			Optional<Carrera> carrera = carreraRepository.findById(id);

			if (carrera.isPresent()) 
				carreraRepository.delete(carrera.get());	
		}
	}
}
