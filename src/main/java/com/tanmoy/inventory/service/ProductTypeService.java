package com.tanmoy.inventory.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.ProductType;
import com.tanmoy.inventory.repository.ProductTypeRepo;

@Service
public class ProductTypeService extends AbstractService<ProductType> {

	private ProductTypeRepo ptRepo;

	@Autowired
	public ProductTypeService(ProductTypeRepo ptRepo) {
		this.ptRepo = ptRepo;
	}

	@Override
	public ProductType findById(int id) {
		try {
			return ptRepo.findById(id);
		} catch (NoSuchElementException e) {
			log.info("No such product type with id: " + id);
			return null;
		}
	}

	@Override
	public List<ProductType> findAll() {
		return ptRepo.findAll();
	}

	@Override
	public boolean save(ProductType obj) {
		try {
			if (findById(obj.getId()) == null) {
				ptRepo.save(obj);
				return true;
			}
			log.info("ProductType already exists of id: " + obj.getId());
			return false;
		} catch (Exception e) {
			log.info("Failed to add ProductType due to " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(ProductType obj) {
		try {
			ptRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to update ProductType due to " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			ptRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete ProductType of id : "+ id +", due to " + e.getMessage());
			return false;
		}
	}

}
