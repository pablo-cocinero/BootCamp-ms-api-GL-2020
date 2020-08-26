package com.globallogic.bootcamp.vehiculos;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.globallogic.bootcamp.vehiculos.controller.VehiculoController;
import com.globallogic.bootcamp.vehiculos.model.Modelo;
import com.globallogic.bootcamp.vehiculos.model.Tipo;
import com.globallogic.bootcamp.vehiculos.model.Vehiculo;
import com.globallogic.bootcamp.vehiculos.service.VehiculoService;


@WebMvcTest(controllers = VehiculoController.class)
@ActiveProfiles("test")
class VehiculoServiceControllerTest {

	@Autowired                           
    private MockMvc mockMvc; 
	@MockBean 
	VehiculoService vehiculoService;
	
	Vehiculo vehiculo1;
	Optional<Vehiculo> vehiculoO;
	List<Vehiculo> ListVehiculo;
	Modelo modelo1;
	Tipo tipo1;
	
	@BeforeEach
	void setUp() throws Exception {
		vehiculo1 = new Vehiculo();
		modelo1 = new Modelo();
		tipo1 = new Tipo();
		modelo1.setCodigo(1);
		modelo1.setMarca("ford");
		modelo1.setNombre("focus");
		tipo1.setCodigo(1);
		tipo1.setPuertas(5);
		tipo1.setCategoria("sedan");
		vehiculo1.setCodigo(34);
		vehiculo1.setFechaProduccion(new Date());
		vehiculo1.setIdentificacion("ABC-123");
		vehiculo1.setModelo(modelo1);
		vehiculo1.setTipo(tipo1);
		vehiculoO = Optional.of(vehiculo1);
		ListVehiculo = new ArrayList<>();
		ListVehiculo.add(vehiculo1);
	}

	@Test
	@DisplayName("get vehiculos")
	void testCase_01() throws Exception {
		when(vehiculoService.findAll()).thenReturn(ListVehiculo);
		mockMvc.perform(get("/vehiculos"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()",is(ListVehiculo.size())));
	}
	
	@Test
	@DisplayName("get vehiculo por id")
	void testCase_02() throws Exception {
		when(vehiculoService.getById(34)).thenReturn(vehiculo1);
		mockMvc.perform(get("/vehiculos/34"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.codigo",is(vehiculo1.getCodigo())))
		.andExpect(jsonPath("$.identificacion",is(vehiculo1.getIdentificacion())));
	}
	
	@Test
	@DisplayName("post vehiculo")
	void testCase_03() throws Exception {
		when(vehiculoService.create(vehiculo1)).thenReturn(vehiculo1);
		mockMvc.perform(post("/vehiculos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapToJson(vehiculo1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.codigo",is(vehiculo1.getCodigo())))
		.andExpect(jsonPath("$.identificacion",is(vehiculo1.getIdentificacion())));
	}
	
	@Test
	@DisplayName("put vehiculo")
	void testCase_04() throws Exception {
		when(vehiculoService.create(vehiculo1)).thenReturn(vehiculo1);
		when(vehiculoService.update(vehiculo1)).thenReturn(vehiculo1);
		mockMvc.perform(put("/vehiculos/34")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapToJson(vehiculo1)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.codigo",is(vehiculo1.getCodigo())))
		.andExpect(jsonPath("$.identificacion",is(vehiculo1.getIdentificacion())));
		
		when(vehiculoService.getById(34)).thenReturn(vehiculo1);
		mockMvc.perform(put("/vehiculos/34")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapToJson(vehiculo1)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.codigo",is(vehiculo1.getCodigo())))
		.andExpect(jsonPath("$.identificacion",is(vehiculo1.getIdentificacion())));
	}
	
	@Test
	@DisplayName("delete vehiculo")
	void testCase_05() throws Exception {
		mockMvc.perform(delete("/vehiculos/34"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",is("Vehiculo Eliminado")));
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		  ObjectMapper objectMapper = new ObjectMapper();
		  return objectMapper.writeValueAsString(object);
	  }

}
