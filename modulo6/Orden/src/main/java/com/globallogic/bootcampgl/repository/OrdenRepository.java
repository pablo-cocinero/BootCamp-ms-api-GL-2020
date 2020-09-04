package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden,Integer>{

}
