package com.globallogic.bootcampgl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Stock {
	
	@Id
	private Integer id;
	@Column(name = "id_producto")
	private Integer idProducto;
	@Column
	private Integer cantidad;
}
