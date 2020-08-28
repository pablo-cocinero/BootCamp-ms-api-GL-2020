package com.globallogic.bootcampgl.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Component
public class Cliente extends ResourceSupport{

	private Integer DNI;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private List<String> direccion;
}
