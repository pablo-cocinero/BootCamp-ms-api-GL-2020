package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Libro;
import com.globallogic.bootcampgl.repository.LibroRepository;

@Service
public class LibroService {

	LibroRepository libroRepository;
	
	public LibroService(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}
	
	public Libro create(Libro libro) {
		return libroRepository.save(libro);
	}
	
	public Libro findById(Long id) {
		 Optional<Libro> optLibro = libroRepository.findById(id);
		 if(optLibro.isPresent())
		 return optLibro.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Libro> findAll(){
		return libroRepository.findAll();
	}
	
	public Libro update(Libro libro) {
		
		Libro Old = findById(libro.getIsbn());
		libroRepository.delete(Old);
		return libroRepository.save(libro);
	}
	
	public void delete(Long id) {
		Libro toDelete = findById(id);
		libroRepository.delete(toDelete);
	}
}
