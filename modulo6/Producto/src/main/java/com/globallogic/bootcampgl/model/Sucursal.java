package com.globallogic.bootcampgl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
@Controller
@Entity
public class Sucursal {

	@Id
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String ubicacion;
	@OneToMany
	@JoinColumn
	private List<Stock> stocks;
}
