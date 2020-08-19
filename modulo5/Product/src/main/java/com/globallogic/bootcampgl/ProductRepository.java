package com.globallogic.bootcampgl;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class ProductRepository {

	
	private List<Product> products;
	
	public Product getById(String id)
	{
		for(Product p : products)
			if(p.getId().equals(id))
				return p;
		return null;
	}
}
