package com.globallogic.bootcampgl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Compra {
	
	@Id
	Integer id;
	@Column(name = "id_producto")
	Integer idProducto;
	@Column
	Integer cantidad;
}
