package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Stock;

public interface StockRepo extends JpaRepository<Stock, Integer>{

}
