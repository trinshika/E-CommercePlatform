package com.management.app.service;

import java.util.List;

import com.management.app.model.Product;

public interface ProductIService {

	public Product save(Product pd);
	public List<Product> getProduct();
	public Product getOne(Long id);
	public void delete(Long id);
}
