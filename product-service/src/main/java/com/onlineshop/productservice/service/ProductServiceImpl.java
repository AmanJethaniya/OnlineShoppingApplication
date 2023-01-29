package com.onlineshop.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.productservice.entity.ProductEntity;
import com.onlineshop.productservice.model.ProductRequest;
import com.onlineshop.productservice.model.ProductResponse;
import com.onlineshop.productservice.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ProductServiceImpl implements ProductService{
	private static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	  
	  @Autowired
	  private ModelMapper mapper;
	  
	  @Autowired
	  private ProductRepository repository;
	  public ProductResponse createProduct(ProductRequest productRequest) {
		    LOGGER.info("Inside service layer and value of received object is {}", productRequest);
		    ProductEntity entity = mapper.map(productRequest, ProductEntity.class);
		    LOGGER.info("Value of converted entity {}", entity);
		    ProductEntity savedEntity = repository.insert(entity);
		    LOGGER.info("Product record saveed successfully with ID as {}", savedEntity.getId());
		    return mapper.map(savedEntity, ProductResponse.class);
		  }
		  
		  public List<ProductResponse> getAllProducts() {
		    LOGGER.info("Inside service layer, fetching all the records...");
		    List<ProductEntity> list = repository.findAll();
		    List<ProductResponse> response = new ArrayList();
		    for (ProductEntity entity : list)
		      response.add((ProductResponse)this.mapper.map(entity, ProductResponse.class)); 
		    return response;
		  }
	  

}
