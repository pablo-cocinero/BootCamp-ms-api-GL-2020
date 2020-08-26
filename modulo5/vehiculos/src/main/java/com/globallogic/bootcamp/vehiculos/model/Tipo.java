package com.globallogic.bootcamp.vehiculos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
//@AllArgsConstructor
@Entity
@Table(name = "tipo")
public class Tipo {
	
	@Id
	private Integer codigo;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="puertas")
	private Integer puertas;
}
