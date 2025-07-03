package com.management.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.app.model.Product;

@Repository
public interface ProductIRepo extends JpaRepository<Product, Long>{

}
//