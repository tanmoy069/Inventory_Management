package com.tanmoy.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Stock;

public interface StockRepo extends JpaRepository<Stock, Integer>{
	
	Stock findById(int id);
	List<Stock> findByProductId(int productId);

}
