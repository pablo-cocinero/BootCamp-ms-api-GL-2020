package com.globallogic.bootcampgl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
public class Genero {

	@Id
	Integer id;
	@Column
	String nombre;
}
