package com.globallogic.bootcampgl.error;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResponse {

	@JsonProperty("message")
	private String mensaje;
	
	@JsonProperty("satus_code")
	private HttpStatus estado;
	
	@JsonProperty("uri")
	private String url;
}
