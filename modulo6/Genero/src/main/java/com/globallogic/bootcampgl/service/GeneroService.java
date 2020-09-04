package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Genero;
import com.globallogic.bootcampgl.repository.GeneroRepository;


@Service
public class GeneroService {

	GeneroRepository generoRepository;
	
	public GeneroService(GeneroRepository generoRepository) {
		this.generoRepository = generoRepository;
	}
	
	public Genero create(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero findById(Integer id) {
		 Optional<Genero> optLibro = generoRepository.findById(id);
		 if(optLibro.isPresent())
		 return optLibro.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Genero> findAll(){
		return generoRepository.findAll();
	}
	
	public Genero update(Genero genero) {
		
		Genero Old = findById(genero.getId());
		generoRepository.delete(Old);
		return generoRepository.save(genero);
	}
	
	public void delete(Integer id) {
		Genero toDelete = findById(id);
		generoRepository.delete(toDelete);
	}
}
