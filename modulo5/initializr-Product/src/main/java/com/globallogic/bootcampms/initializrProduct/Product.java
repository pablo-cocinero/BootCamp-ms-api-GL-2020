package com.globallogic.bootcampms.initializrProduct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Product {
	
	@Value("${in.id}")
	private String id;
	
	@Value("${in.name}")
	private String name;
}
