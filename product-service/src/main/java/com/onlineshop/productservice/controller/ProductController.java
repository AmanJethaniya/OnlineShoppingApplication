package com.onlineshop.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.productservice.model.ProductRequest;
import com.onlineshop.productservice.model.ProductResponse;
import com.onlineshop.productservice.service.ProductService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping({"/api/product"})
public class ProductController {
	private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	  
	  @Autowired
	  private ProductService service;
	  
	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public ResponseEntity<Object> createProduct(@RequestBody ProductRequest productRequest) {
	    LOGGER.info("Request received at post endpoint with payload value as {} ", productRequest);
	    return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(productRequest));
	  }
	  
	  @GetMapping
	  @ResponseStatus( HttpStatus.OK)
	  public ResponseEntity<List<ProductResponse>> getAllProduct() {
	    LOGGER.info("Request received at get endpoint endpoint");
	    return ResponseEntity.ok(service.getAllProducts());
	  }

}
