package com.management.app.mapper;

import org.springframework.stereotype.Component;

import com.management.app.dto.ProductInDto;
import com.management.app.dto.ProductOutDto;
import com.management.app.dto.UserOutDto;
import com.management.app.model.Product;
import com.management.app.model.User;

@Component
public class ProductMapper {

	public Product ProductInDtoToProductEntity(ProductInDto productInDto) {
		
		 return new Product(productInDto.getId(),
						productInDto.getName(),
						productInDto.getDescription(), 
						productInDto.getPrice(),
						productInDto.getQuantity());
	}
	
	public ProductOutDto ProductToProductOutDto(Product product){
		return new ProductOutDto();
	}
}
