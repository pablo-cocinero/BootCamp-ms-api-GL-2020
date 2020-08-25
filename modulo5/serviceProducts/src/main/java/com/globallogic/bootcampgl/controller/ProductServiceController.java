package com.globallogic.bootcampgl.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dto.ProductDTO;
import com.globallogic.bootcampgl.service.impl.ProductServiceImpl;

/**
 * Product Service Controller
 */
@RestController
public class ProductServiceController 
	{

		ProductServiceImpl productService = new ProductServiceImpl();
		
		@RequestMapping(value = "/products")
		public ResponseEntity<Object> getProduct() 
		{
			return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
		}
		
		@RequestMapping(value = "/products", method = RequestMethod.POST)
		public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductDTO productDTO)
		{
			productService.createProduct(productDTO);
			return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		}
		
		@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @Valid @RequestBody ProductDTO productDTO)
		{
			productService.updateProduct(id, productDTO);
			return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		}
		
		@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id)
		{
			productService.deleteProduct(id);
			return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
		}
		
}
