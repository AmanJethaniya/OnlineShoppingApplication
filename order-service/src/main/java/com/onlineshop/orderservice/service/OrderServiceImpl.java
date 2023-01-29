package com.onlineshop.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.onlineshop.orderservice.entity.OrderEntity;
import com.onlineshop.orderservice.entity.OrderLineItemEntity;
import com.onlineshop.orderservice.model.OrderLineItem;
import com.onlineshop.orderservice.model.OrderRequest;
import com.onlineshop.orderservice.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private OrderRepository repository;
	@Autowired
	private WebClient webClient;
	@Override
	public void placeOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		OrderEntity order = new OrderEntity();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItemEntity> orderLineIteamEntity = new ArrayList<>();
		List<OrderLineItem> list = orderRequest.getOrderLineItems();
		for(OrderLineItem item : list) {
			orderLineIteamEntity.add(mapper.map(item, OrderLineItemEntity.class));
		}
		order.setOrderLineItems(orderLineIteamEntity);
		//Call inventory Service and place order if product is in stock
		Boolean result = webClient.get()
				 .uri("http:localhost:8082/api/inventory")
				 .retrieve()
				 .bodyToMono(Boolean.class)
				 .block();
		
		if(result) {
			repository.save(order);
		} else {
			throw new IllegalArgumentException("Product is not in stock, please try again later");
		}
		
		
	}
	

}
