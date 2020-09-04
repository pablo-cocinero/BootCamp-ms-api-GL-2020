package com.globallogic.bootcampgl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Autor {

	@Id
	Integer id;
	@Column
	String nombre;
	@Column
	String nacionalidad;
}
