package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{

}
