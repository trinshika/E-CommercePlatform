package com.management.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	private Integer quantity;
	
	
}
