package com.management.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.app.model.Product;
import com.management.app.service.ProductIService;

@RestController
@RequestMapping("product")
public class ProductController {

	
	@Autowired
	ProductIService productIService;
	
	@PostMapping("save")
	public Product save(@RequestBody Product pd) {
		return productIService.save(pd);
	}
	
	@PutMapping("update")
	public Product update(@RequestBody Product pd) {
		return productIService.save(pd);
	}
	
	@GetMapping("get-all")
	public List<Product> getProduct() {
		return productIService.getProduct();
	}
	
	@GetMapping("get-one/{id}")
	public Product getOne(@PathVariable("id") Long id) {
		return productIService.getOne(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		productIService.delete(id);
	}
	
}
