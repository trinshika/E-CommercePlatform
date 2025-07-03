package com.management.app.service;

import java.util.List;

import com.management.app.dto.ProductInDto;
import com.management.app.model.Product;

public interface ProductIService {

	public String save(ProductInDto productInDto);
	public List<Product> getProduct();
	public Product getOne(Long id);
	public void delete(Long id);
}
