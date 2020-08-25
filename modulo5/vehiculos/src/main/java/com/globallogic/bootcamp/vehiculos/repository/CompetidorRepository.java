package com.globallogic.bootcamp.vehiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcamp.vehiculos.model.Competidor;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor,Integer>{

	
}
