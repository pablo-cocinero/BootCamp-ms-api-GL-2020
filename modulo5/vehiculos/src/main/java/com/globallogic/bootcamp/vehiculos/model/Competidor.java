package com.globallogic.bootcamp.vehiculos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
@Table(name = "competidor")
public class Competidor {

	@Id
	private Integer numero;
	@Column(name = "nombre")
	private String nombre;
}
