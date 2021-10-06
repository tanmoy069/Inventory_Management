package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.Stock;
import com.tanmoy.inventory.repository.StockRepo;

@Service
public class StockService extends AbstractService<Stock> {

	private StockRepo stockRepo;
	
	@Autowired
	public StockService(StockRepo stockRepo) {
		this.stockRepo = stockRepo;
	}

	@Override
	public Stock findById(int id) {
		try {
			return stockRepo.findById(id);
		} catch (Exception e) {
			log.info("No such Stock which id is: " + id);
			return null;
		}
	}
	
	public Stock findByProductId(int productId) {
		try {
			return stockRepo.findByProductId(productId);
		} catch (Exception e) {
			log.info("No such Stock which product id is: " + productId);
			return null;
		}
	}

	@Override
	public List<Stock> findAll() {
		return stockRepo.findAll();
	}

	@Override
	public boolean save(Stock obj) {
		try {
			if (findById(obj.getAutoId()) == null) {
				stockRepo.save(obj);
				return true;
			}
			log.info("Already exists Stock which id is: " + obj.getAutoId());
			return false;
		} catch (Exception e) {
			log.info("Failed to save Stock");
			return false;
		}
	}

	@Override
	public boolean update(Stock obj) {
		try {
			if(findById(obj.getAutoId()) != null) {
				stockRepo.save(obj);
				return true;
			}
			log.info("Unable to update Stock, Stock doesn't exists");
			return false;
		} catch (Exception e) {
			log.info("Failed to update Stock where id is: " + obj.getAutoId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			stockRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete Stock where id is: " + id);
			return false;
		}
	}

}
