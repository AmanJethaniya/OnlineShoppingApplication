package com.onlineshop.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.inventoryservice.model.InventoryResponse;
import com.onlineshop.inventoryservice.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		log.info("Inside service layer, with skuCode value as {}", skuCode);
		return repository.findBySkuCodeIn(skuCode).stream()
				.map(inventory -> InventoryResponse.builder()
						.skuCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity()>0)
						.build()
						).toList();
	}

}
