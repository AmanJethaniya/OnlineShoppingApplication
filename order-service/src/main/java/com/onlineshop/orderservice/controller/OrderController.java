package com.onlineshop.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.orderservice.model.OrderRequest;
import com.onlineshop.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		service.placeOrder(orderRequest);
		return "Order Placed successfully";
		
	}

}
