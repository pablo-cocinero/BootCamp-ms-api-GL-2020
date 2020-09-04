package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Autor;
import com.globallogic.bootcampgl.repository.AutorRepository;

@Service
public class AutorService {

AutorRepository autorRepository;
	
	public AutorService(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	public Autor create(Autor libro) {
		return autorRepository.save(libro);
	}
	
	public Autor findById(Integer id) {
		 Optional<Autor> optLibro = autorRepository.findById(id);
		 if(optLibro.isPresent())
		 return optLibro.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Autor> findAll(){
		return autorRepository.findAll();
	}
	
	public Autor update(Autor libro) {
		
		Autor Old = findById(libro.getId());
		autorRepository.delete(Old);
		return autorRepository.save(libro);
	}
	
	public void delete(Integer id) {
		Autor toDelete = findById(id);
		autorRepository.delete(toDelete);
	}
}
