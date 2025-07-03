package com.management.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.app.dto.ProductInDto;
import com.management.app.model.Product;
import com.management.app.service.ProductIService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("product")
@Slf4j
public class ProductController {

	
	@Autowired
	ProductIService productIService;
	
	@PostMapping("save")
	public ResponseEntity<String> save(@RequestBody ProductInDto productInDto) {
		log.info("Entered into Product/save controller");
		log.debug("product data: "+ productInDto.toString());
		
		return new ResponseEntity<>(productIService.save(productInDto), HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> update(@RequestBody ProductInDto productInDto) {
		log.info("Entered into Product/update controller");
		log.debug("product data: "+ productInDto.toString());
		
		 return new ResponseEntity<>(productIService.save(productInDto), HttpStatus.OK);
	}
	
	@GetMapping("get-all")
	public ResponseEntity<List<Product>> getProduct() {
		log.info("Entered into Product/getProduct controller");
		
		return new ResponseEntity<>(productIService.getProduct(), HttpStatus.OK);
	}
	
	@GetMapping("get-one/{id}")
	public ResponseEntity<Product> getOne(@PathVariable("id") Long id) {
		log.info("Entered into Product/getOne controller");
		log.debug("product id: "+ id);
		
		return new ResponseEntity<>(productIService.getOne(id), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		log.info("Entered into Product/delete controller");
		log.debug("product id: "+ id);
		
		productIService.delete(id);
		return new ResponseEntity<>("Product has been deleted", HttpStatus.OK);	
	}
	
	//write a api for getting product list beetween a price range.
	
}
