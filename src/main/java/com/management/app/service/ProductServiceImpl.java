package com.management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.app.dto.ProductInDto;
import com.management.app.mapper.ProductMapper;
import com.management.app.mapper.UserMapper;
import com.management.app.model.Product;
import com.management.app.repo.ProductIRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductIService{

	@Autowired
	ProductIRepo productIRepo;
	
	@Autowired
	ProductMapper productMapper;
	
	public String save(ProductInDto productInDto) {
		log.info("entered into Product service save method");
		log.debug("Product data: " + productInDto.toString());
		
		
		Product pd = productMapper.ProductInDtoToProductEntity(productInDto);
		
		productIRepo.save(pd);
		return "product has been saved";
	}
	
	public List<Product> getProduct() {
		log.info("entered into Product service getProduct method");
		
		return productIRepo.findAll();
	}
	
	public Product getOne(Long id) {
		log.info("entered into Product service getOne method");
		log.debug("Product id: " + id);
		
		return productIRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		log.info("entered into Product service delete method");
		log.debug("Product id: " + id);
		
		productIRepo.deleteById(id);
	}

}
