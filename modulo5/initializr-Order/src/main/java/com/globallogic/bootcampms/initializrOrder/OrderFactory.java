package com.globallogic.bootcampms.initializrOrder;

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

	public OrderFactory(Order order) {
		this.order = order;
	}
}
