package com.globallogic.bootcampgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class OrderFactory {
	
	@Autowired
	private Order order;
	
	public Order getNewOrder()
	{
		return order;
	}

	public OrderFactory() {
		this.order = new Order();
	}
}
