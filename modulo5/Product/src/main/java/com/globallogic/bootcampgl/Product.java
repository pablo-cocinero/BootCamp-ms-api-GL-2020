package com.globallogic.bootcampgl;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class Product {

	private String id;
	private String name;
}
