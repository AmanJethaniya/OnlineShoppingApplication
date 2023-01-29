package com.onlineshop.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.productservice.entity.ProductEntity;
@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
