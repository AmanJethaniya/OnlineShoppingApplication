package com.onlineshop.productservice.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductResponse {
	private String id;
	private String name;
    private String description;
    private BigDecimal price;

}
