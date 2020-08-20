package com.globallogic.bootcampms.initializrOrder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Order {
	
	@Value("${in.product}")
	private String product;

	@Value("${in.count}")
	private Integer count;
	
	@Value("${in.customer}")
	private Integer customer;
	
}