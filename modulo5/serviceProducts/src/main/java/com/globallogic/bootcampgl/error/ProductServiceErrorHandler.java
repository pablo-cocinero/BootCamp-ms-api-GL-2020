package com.globallogic.bootcampgl.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ProductServiceErrorHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> RequestWithoutBody(HttpMessageNotReadableException exception,WebRequest request )
	{
		ErrorResponse error = new ErrorResponse();
		error.setMensaje(exception.getMessage());
		error.setEstado(HttpStatus.BAD_REQUEST);
		error.setUrl(((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> RequestWithBlankParameters(MethodArgumentNotValidException exception, WebRequest request)
	{
		ErrorResponse error = new ErrorResponse();
		error.setMensaje(exception.getMessage());
		error.setEstado(HttpStatus.BAD_REQUEST);
		error.setUrl(((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
