package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Stock;
import com.globallogic.bootcampgl.model.Sucursal;
import com.globallogic.bootcampgl.repository.StockRepository;
import com.globallogic.bootcampgl.repository.SucursalRepository;


@Service
public class SucursalService {

	SucursalRepository sucursalRepository;
	StockRepository stockRepository;
	
	public SucursalService(SucursalRepository sucursalRepository, StockRepository stockRepository) {
		this.sucursalRepository = sucursalRepository;
		this.stockRepository = stockRepository;
	}
	
	public Sucursal create(Sucursal sucursal) {
		List<Stock> stocks = sucursal.getStocks();
		for(Stock stock : stocks)
			stockRepository.save(stock);
		return sucursalRepository.save(sucursal);
	}
	
	public Sucursal findById(Integer id) {
		 Optional<Sucursal> optSucursal = sucursalRepository.findById(id);
		 if(optSucursal.isPresent())
		 return optSucursal.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Sucursal> findAll(){
		return sucursalRepository.findAll();
	}
	
	public Sucursal update(Sucursal sucursal) {
		
		Sucursal Old = findById(sucursal.getId());
		sucursalRepository.delete(Old);
		return sucursalRepository.save(sucursal);
	}
	
	public void delete(Integer id) {
		Sucursal toDelete = findById(id);
		sucursalRepository.delete(toDelete);
	}
}
