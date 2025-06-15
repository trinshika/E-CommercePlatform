package com.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.app.model.Product;
import com.management.app.repo.ProductIRepo;

@Service
public class ProductServiceImpl implements ProductIService{

	@Autowired
	ProductIRepo productIRepo;
	
	public Product save(Product pd) {
		return productIRepo.save(pd);
	}
	
	public List<Product> getProduct() {
		return productIRepo.findAll();
	}
	
	public Product getOne(Long id) {
		return productIRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		productIRepo.deleteById(id);
	}
}
