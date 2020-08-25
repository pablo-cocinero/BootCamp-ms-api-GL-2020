package com.globallogic.bootcamp.vehiculos.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcamp.vehiculos.model.Vehiculo;
import com.globallogic.bootcamp.vehiculos.repository.VehiculoRepository;

@Service
public class VehiculoService {

	private VehiculoRepository vehiculoRepository;
	
	public VehiculoService(VehiculoRepository vehiculoRepository)
	{
		this.vehiculoRepository = vehiculoRepository;
	}
	
	public Vehiculo create(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}
	
	public Vehiculo getById(Integer id) {
		
		if (isNull(id))	return null;

		Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);

		if (vehiculo.isPresent())
			return vehiculo.get();
		else
			return null;
	}
	
	public List<Vehiculo> findAll(){
		return vehiculoRepository.findAll();
	}
	
	public Vehiculo update(Vehiculo vehiculo) {

		return vehiculoRepository.save(vehiculo);
	}
	
	public void delete(Integer id) {

		if (nonNull(id)) {
			
			Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);

			if (vehiculo.isPresent()) 
				vehiculoRepository.delete(vehiculo.get());	
		}
	}
}
