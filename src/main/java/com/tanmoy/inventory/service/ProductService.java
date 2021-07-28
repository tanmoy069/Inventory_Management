package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.Product;
import com.tanmoy.inventory.repository.ProductRepo;

@Service
public class ProductService extends AbstractService<Product> {

	private ProductRepo proRepo;

	@Autowired
	public ProductService(ProductRepo proRepo) {
		this.proRepo = proRepo;
	}

	@Override
	public Product findById(int id) {
		return proRepo.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return proRepo.findAll();
	}

	@Override
	public boolean save(Product obj) {
		try {
			if (findById(obj.getId()) == null) {
				proRepo.save(obj);
				return true;
			}
			return false;
		} catch (Exception e) {
			log.info("Failed to insert product id -" + obj.getId() + " to Product");
			return false;
		}
	}

	@Override
	public boolean update(Product obj) {
		try {
			proRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to update product id-" + obj.getId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			proRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete product id-" + id + " from Product");
			return false;
		}
	}

}
