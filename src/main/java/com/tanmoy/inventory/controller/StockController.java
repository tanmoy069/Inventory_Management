package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/findby")
	public Stock getProductById(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "productId", required = false) String productId) {
		if(id == null) return stockService.findByProductId(stockService.getInt(productId));
		return stockService.findById(stockService.getInt(id));
	}
	
	@PostMapping("/save")
	public boolean saveStock(Stock stock) {
		return stockService.save(stock);
	}
	
	@PostMapping("/delete")
	public boolean deleteStock(@RequestParam(name = "id", required = true) String id) {
		return stockService.deleteById(stockService.getInt(id));
	}
	
	@PostMapping("/update")
	public boolean updateStock(@RequestParam(name = "id", required = true) String id,
			@RequestParam(name = "productId", required = false) String productId,
			@RequestParam(name = "availableStocks", required = false) String availableStocks,
			@RequestParam(name = "isStockUpdate", required = false) String isStockUpdate,
			@RequestParam(name = "stockInDate", required = false) String stockInDate,
			@RequestParam(name = "stockOutDate", required = false) String stockOutDate) {
		Stock stock = stockService.findById(stockService.getInt(id));
		if(stock == null) return false;
		if(productId != null) stock.setProductId(stockService.getInt(productId));
		if(availableStocks != null) stock.setAvailableStocks(stockService.getInt(availableStocks));
		if(isStockUpdate != null) stock.setStockUpdate((short)stockService.getInt(isStockUpdate));
		if(stockInDate != null) stock.setStockInDate(stockService.getDate(stockInDate));
		if(stockOutDate != null) stock.setStockOutDate(stockService.getDate(stockOutDate));
		return stockService.update(stock);
	}

}
