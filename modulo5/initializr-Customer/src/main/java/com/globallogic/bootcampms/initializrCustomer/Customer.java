package com.globallogic.bootcampms.initializrCustomer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {
	
	@Value("${in.name}")
	private String name;
	
	@Value("${in.dni}")
	private Integer dni;
	
	@Value("${in.id}")
	private Integer id;
}
