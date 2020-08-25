package com.globallogic.bootcamp.vehiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcamp.vehiculos.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Integer>{

}
