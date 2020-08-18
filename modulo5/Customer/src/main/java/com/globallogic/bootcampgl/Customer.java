package com.globallogic.bootcampgl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private String name;
	private Integer dni;
	private Integer id;
}
