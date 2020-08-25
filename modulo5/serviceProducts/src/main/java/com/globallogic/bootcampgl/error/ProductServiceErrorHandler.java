package com.globallogic.bootcampgl.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceErrorHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> RequestWithoutBody(HttpMessageNotReadableException exception)
	{
//		ErrorResponse error = new ErrorResponse();
//		error.setMensaje(exception.getMessage());
//		error.setEstado(HttpStatus.BAD_REQUEST);
//		error.setUrl(url);
		return new ResponseEntity<>("ERROR MENSAJE MAL FORMADO", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> RequestWithBlankParameters(MethodArgumentNotValidException exception)
	{
		return new ResponseEntity<>("ERROR EN DATOS ESPERADOS", HttpStatus.BAD_REQUEST);
	}
}
