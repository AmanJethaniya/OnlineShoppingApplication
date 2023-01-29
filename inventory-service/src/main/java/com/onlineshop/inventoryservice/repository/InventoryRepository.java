package com.onlineshop.inventoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.inventoryservice.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{
	List<InventoryEntity> findBySkuCodeIn(List<String> skuCode);

}
