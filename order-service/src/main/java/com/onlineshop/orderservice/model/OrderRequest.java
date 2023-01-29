package com.onlineshop.orderservice.model;

import java.util.List;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	private List<OrderLineItem> orderLineItems;

}
