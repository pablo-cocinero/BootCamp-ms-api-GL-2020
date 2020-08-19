package com.globallogic.bootcampgl;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Order {

	private String product = "C-00221";
	private Integer count = 1000;
	private Integer customer = 12342;
	
}
