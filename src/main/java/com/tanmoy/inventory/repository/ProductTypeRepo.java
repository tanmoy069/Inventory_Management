package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.ProductType;

public interface ProductTypeRepo extends JpaRepository<ProductType, Integer>{

	ProductType findById(int i);
}
