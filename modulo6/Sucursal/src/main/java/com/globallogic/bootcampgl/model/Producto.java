package com.globallogic.bootcampgl.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;
import javax.persistence.Id;
import lombok.Data;

@Data
@Component
@Entity
public class Producto {

	@Id
	private Integer Id;
	@Column
	private String nombre;
	
}
