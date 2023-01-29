package com.onlineshop.inventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.inventoryservice.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{
	Optional<InventoryEntity> findBySkuCode(String skuCode); 

}
