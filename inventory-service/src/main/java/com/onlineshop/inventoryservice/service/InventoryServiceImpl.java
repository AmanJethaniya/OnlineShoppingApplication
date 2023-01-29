package com.onlineshop.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.inventoryservice.model.InventoryResponse;
import com.onlineshop.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		// TODO Auto-generated method stub
		return repository.findBySkuCodeIn(skuCode).stream()
				.map(inventory -> InventoryResponse.builder()
						.skuCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity()>0)
						.build()
						).toList();
	}

}
