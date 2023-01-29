package com.onlineshop.inventoryservice.service;

import java.util.List;

import com.onlineshop.inventoryservice.model.InventoryResponse;

public interface InventoryService {
	List<InventoryResponse> isInStock(List<String> skuCode);

}
