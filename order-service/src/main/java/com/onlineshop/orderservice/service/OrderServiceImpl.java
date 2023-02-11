package com.onlineshop.orderservice.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.onlineshop.orderservice.entity.OrderEntity;
import com.onlineshop.orderservice.entity.OrderLineItemEntity;
import com.onlineshop.orderservice.model.InventoryResponse;
import com.onlineshop.orderservice.model.OrderLineItem;
import com.onlineshop.orderservice.model.OrderRequest;
import com.onlineshop.orderservice.repository.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private OrderRepository repository;
	@Autowired
	private RestTemplate template;
	@Override
	public void placeOrder(OrderRequest orderRequest) {
		log.info("Inside service class..");
		OrderEntity order = new OrderEntity();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItemEntity> orderLineIteamEntity = new ArrayList<>();
		List<OrderLineItem> list = orderRequest.getOrderLineItems();
		for(OrderLineItem item : list) {
			orderLineIteamEntity.add(mapper.map(item, OrderLineItemEntity.class));
		}
		order.setOrderLineItems(orderLineIteamEntity);
		List<String> skuCodes = order.getOrderLineItems().stream().map(item->item.getSkuCode()).toList();
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("http").host("localhost:8082")
			      .path("/api/inventory").query("skuCode={keyword}").buildAndExpand(String.join("&skuCode=", skuCodes));
		log.info("performing rest operation on {}", uriComponents.toString());
		ResponseEntity<InventoryResponse[]> inventoryResponses1 = template.getForEntity(uriComponents.toString(), InventoryResponse[].class);
		//checking whether all the skuCode are in stock
		log.info("Response received from inventory is {} ", inventoryResponses1.getBody());
		Boolean allProductsInStock = Arrays.stream(inventoryResponses1.getBody()).allMatch(response -> response.isInStock());
		
		if(allProductsInStock) {
			repository.save(order);
		} else {
			throw new IllegalArgumentException("Product is not in stock, please try again later");
		}
		
		
	}
	

}
