package com.globallogic.bootcampgl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Stock;
import com.globallogic.bootcampgl.repository.StockRepository;

@Service
public class StockService {

	StockRepository stockRepository;
	
	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}
	
	public Stock create(Stock stock) {
		return stockRepository.save(stock);
	}
	
	public Stock findById(Integer id) {
		 Optional<Stock> optStock = stockRepository.findById(id);
		 if(optStock.isPresent())
		 return optStock.get();
		 else
			 throw new NoSuchElementException();
	}
	
	public List<Stock> findAll(){
		return stockRepository.findAll();
	}
	
	public Stock update(Stock stock) {
		
		Stock Old = findById(stock.getId());
		stockRepository.delete(Old);
		return stockRepository.save(stock);
	}
	
	public void delete(Integer id) {
		Stock toDelete = findById(id);
		stockRepository.delete(toDelete);
	}
}
