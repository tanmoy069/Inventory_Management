package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	Product findById(int id);
}
