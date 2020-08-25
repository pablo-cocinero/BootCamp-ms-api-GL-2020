package com.globallogic.bootcamp.vehiculos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
@Table(name = "carrera")
public class Carrera {

	@Column(name = "fecha")
	private Date fecha;
	@Id
	private String nombre;
	@OneToMany
	@JoinColumn(name = "competidor_id")
	private List<Competidor> competidores;
}
