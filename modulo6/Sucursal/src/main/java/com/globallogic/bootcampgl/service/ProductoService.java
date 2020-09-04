package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Producto;
import com.globallogic.bootcampgl.repository.ProductoRepository;

@Service
public class ProductoService {

	ProductoRepository productoRepository;
	
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public Producto findById(Integer id) {
		 Optional<Producto> optProducto = productoRepository.findById(id);
		 if(optProducto.isPresent())
		 return optProducto.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Producto> findAll(){
		return productoRepository.findAll();
	}
	
	public Producto update(Producto producto) {
		
		Producto Old = findById(producto.getId());
		productoRepository.delete(Old);
		return productoRepository.save(producto);
	}
	
	public void delete(Integer id) {
		Producto toDelete = findById(id);
		productoRepository.delete(toDelete);
	}
}
