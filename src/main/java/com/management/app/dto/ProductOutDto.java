package com.management.app.dto;

import lombok.Data;

@Data
public class ProductOutDto {

	private Long id;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	private Integer quantity;
}
