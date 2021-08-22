package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.Supplier;
import com.tanmoy.inventory.repository.SupplierRepo;

@Service
public class SupplierService extends AbstractService<Supplier> {

	private SupplierRepo suppRepo;

	@Autowired
	public SupplierService(SupplierRepo suppRepo) {
		this.suppRepo = suppRepo;
	}

	@Override
	public Supplier findById(int id) {
		try {
			return suppRepo.findById(id);
		} catch (Exception e) {
			log.info("No such Supplier which id is: " + id);
			return null;
		}
	}
	
	public Supplier findByPhone(int phone) {
		return suppRepo.findByPrimaryPhone(phone);
	}
	
	public Supplier findByEmail(String email) {
		return suppRepo.findByEmail(email);
	}
	
	public List<Supplier> findByCompanyNameContains(String comapanyName){
		return suppRepo.findByCompanyNameContains(comapanyName);
	}
	
	public List<Supplier> findByNameContains(String name){
		return suppRepo.findByNameContains(name);
	}

	@Override
	public List<Supplier> findAll() {
		return suppRepo.findAll();
	}

	@Override
	public boolean save(Supplier obj) {
		try {
			if (findById(obj.getId()) == null) {
				suppRepo.save(obj);
				return true;
			}
			log.info("Already exist Supplier");
			return false;
		} catch (Exception e) {
			log.info("Failed to save supplier");
			return false;
		}
	}

	@Override
	public boolean update(Supplier obj) {
		try {
			suppRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to update supplier's id: " + obj.getId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			suppRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete supplier's id: " + id);
			return false;
		}
	}

}
