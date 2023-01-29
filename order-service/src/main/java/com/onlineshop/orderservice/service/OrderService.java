package com.onlineshop.orderservice.service;

import com.onlineshop.orderservice.model.OrderRequest;

public interface OrderService {
	public void placeOrder(OrderRequest orderRequest);

}
