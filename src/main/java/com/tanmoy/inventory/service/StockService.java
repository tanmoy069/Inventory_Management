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
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Stock obj) {
		try {
			stockRepo.save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			stockRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
