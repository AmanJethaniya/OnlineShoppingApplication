package com.onlineshop.productservice.service;

import java.util.List;

import com.onlineshop.productservice.model.ProductRequest;
import com.onlineshop.productservice.model.ProductResponse;

public interface ProductService {
	ProductResponse createProduct(ProductRequest paramProductRequest);
	  
	  List<ProductResponse> getAllProducts();

}
