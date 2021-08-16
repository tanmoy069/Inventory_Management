package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.Customer;
import com.tanmoy.inventory.repository.CustomerRepo;

@Service
public class CustomerService extends AbstractService<Customer>{

	private CustomerRepo custRepo;
	
	@Autowired
	public CustomerService(CustomerRepo custRepo) {
		this.custRepo = custRepo;
	}
	
	@Override
	public Customer findById(int id) {
		return custRepo.findById(id);
	}
	
	public Customer findByUserName(String userName) {
		return custRepo.findByUserName(userName);
	}
	
	public Customer findByEmail(String email) {
		return custRepo.findByEmail(email);
	}

	@Override
	public List<Customer> findAll() {
		return custRepo.findAll();
	}

	@Override
	public boolean save(Customer obj) {
		try {
			if(findByUserName(obj.getUserName()) == null) {
				custRepo.save(obj);
				return true;
			}
			return false;
		} catch (Exception e) {
			log.info("Failed to insert user-" + obj.getUserName() + " to Customer");
			return false;
		}
	}

	@Override
	public boolean update(Customer obj) {
		try {
			custRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to update customer user name-" + obj.getUserName());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			custRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete id-" + id + " from Customer");
			return false;
		}
	}

}
