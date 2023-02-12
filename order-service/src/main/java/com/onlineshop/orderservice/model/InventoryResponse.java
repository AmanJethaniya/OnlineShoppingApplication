package com.onlineshop.orderservice.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
	private String skuCode;
	private boolean isInStock; 

}
