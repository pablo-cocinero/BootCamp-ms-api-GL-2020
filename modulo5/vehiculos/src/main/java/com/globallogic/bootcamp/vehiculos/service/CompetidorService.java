package com.globallogic.bootcamp.vehiculos.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcamp.vehiculos.model.Competidor;
import com.globallogic.bootcamp.vehiculos.repository.CompetidorRepository;

@Service
public class CompetidorService {

private CompetidorRepository competidorRepository;
	
	public CompetidorService(CompetidorRepository competidorRepository)
	{
		this.competidorRepository = competidorRepository;
	}
	
	public Competidor create(Competidor competidor) {
		return competidorRepository.save(competidor);
	}
	
	public Competidor getById(Integer id) {
		
		if (isNull(id))	return null;

		Optional<Competidor> competidor = competidorRepository.findById(id);

		if (competidor.isPresent())
			return competidor.get();
		else
			return null;
	}
	
	public List<Competidor> findAll(){
		return competidorRepository.findAll();
	}
	
	public Competidor update(Competidor competidor) {

		return competidorRepository.save(competidor);
	}
	
	public void delete(Integer id) {

		if (nonNull(id)) {
			
			Optional<Competidor> competidor = competidorRepository.findById(id);

			if (competidor.isPresent()) 
				competidorRepository.delete(competidor.get());	
		}
	}
}
