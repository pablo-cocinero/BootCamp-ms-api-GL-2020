package com.globallogic.bootcampgl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor,Integer>{

}
