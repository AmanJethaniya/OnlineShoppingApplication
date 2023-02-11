package com.onlineshop.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.orderservice.model.OrderRequest;
import com.onlineshop.orderservice.service.OrderService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		log.info("Place order triggered, Inside controller");
		service.placeOrder(orderRequest);
		return "Order Placed successfully";
		
	}

}
