package com.onlineshop.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.onlineshop.inventoryservice.entity.InventoryEntity;
import com.onlineshop.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			InventoryEntity inventory = new InventoryEntity();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);
			
			InventoryEntity inventory1 = new InventoryEntity();
			inventory.setSkuCode("iphone_13_red");
			inventory.setQuantity(0);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}
