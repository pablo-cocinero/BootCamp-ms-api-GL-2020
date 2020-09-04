package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Integer>{

}
