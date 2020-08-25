package com.globallogic.bootcampgl.error;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResponse {

	@JsonProperty("Message")
	private String mensaje;
	
	@JsonProperty("Satus_Code")
	private HttpStatus estado;
	
	@JsonProperty("Url")
	private String url;
}
