package com.globallogic.bootcamp.vehiculos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
//@AllArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	
	@Id
	private Integer codigo;
	
	@Column(name = "indentificacion")
	private String identificacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;
	
	@Column(name = "fecha_produccion")
	private Date fechaProduccion;
	
}
