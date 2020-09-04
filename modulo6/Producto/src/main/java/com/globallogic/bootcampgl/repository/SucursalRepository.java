package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Sucursal;
@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Integer>{

}
