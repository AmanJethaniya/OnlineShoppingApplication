package com.onlineshop.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
