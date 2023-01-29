package com.onlineshop.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.orderservice.entity.OrderEntity;
import com.onlineshop.orderservice.entity.OrderLineItemEntity;
import com.onlineshop.orderservice.model.OrderLineItem;
import com.onlineshop.orderservice.model.OrderRequest;
import com.onlineshop.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private OrderRepository repository;
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
		repository.save(order);
		
	}
	

}
