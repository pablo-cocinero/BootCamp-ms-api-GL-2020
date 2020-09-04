package com.globallogic.bootcampgl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Libro {

	@Id
	Long isbn;
	@Column
	String titulo;
	@Column(name = "id_autor")
	Long idAutor;
	@Column(name = "id_genero")
	Long idGenero;
}
