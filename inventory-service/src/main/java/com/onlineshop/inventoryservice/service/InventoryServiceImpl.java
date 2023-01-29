package com.onlineshop.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository repository;

	@Override
	@Transactional(readOnly = true)
	public boolean isInStock(String skuCode) {
		// TODO Auto-generated method stub
		return repository.findBySkuCode(skuCode).isPresent();
	}

}
