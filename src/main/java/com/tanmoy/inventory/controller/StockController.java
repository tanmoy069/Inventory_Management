package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.Stock;
import com.tanmoy.inventory.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	private StockService stockService;
	
	@Autowired
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
	@GetMapping("/findall")
	public List<Stock> getStockList(){
		return stockService.findAll(); 
	}

}
