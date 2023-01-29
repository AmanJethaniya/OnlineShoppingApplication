package com.onlineshop.orderservice.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {
	private String skuCode;
	private BigDecimal price;
	private  Integer quantity;

}
