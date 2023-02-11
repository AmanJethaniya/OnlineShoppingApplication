package com.onlineshop.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.inventoryservice.model.InventoryResponse;
import com.onlineshop.inventoryservice.service.InventoryService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	@Autowired
	private InventoryService service;
	//http://localhost:8082/api/inventory?sku-code=iphone-13&sku-code=iphone13-red
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		log.info("Triggered isInStock, Inside inventory controller with URL {}", skuCode);
		List<InventoryResponse> response = service.isInStock(skuCode);
		log.info("Response received from service layer: {}", response);
		return response;
		
	}
}
