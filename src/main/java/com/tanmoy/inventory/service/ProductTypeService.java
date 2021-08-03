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
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(ProductType obj) {
		try {
			ptRepo.save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			ptRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
