package com.globallogic.bootcampgl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
public class Orden {

	@Id
	Integer id;
	
	@OneToMany
	@JoinColumn(name = "lista_compra")
	List<Compra> listaCompra;
	
	@Column(name = "id_sucursal")
	Integer idSucursal;
}
