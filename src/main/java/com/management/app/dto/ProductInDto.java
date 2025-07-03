package com.management.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInDto {

	private Long id;
	
	@NotBlank(message = "Product name is required")
	private String name;
	
	@NotBlank(message = "Description of the product is required")
	private String description;
	
	@Min(value = 1, message = "Quantity must be greater than zero")
	private Double price;
	
	@Min(value = 1, message = "Quantity must be greater than zero")
	private Integer quantity;
}
