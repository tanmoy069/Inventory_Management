package com.tanmoy.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	Product findById(int id);
	List<Product> findByProductType(int type);
}
