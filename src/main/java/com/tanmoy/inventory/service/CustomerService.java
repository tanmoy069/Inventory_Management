package com.tanmoy.inventory.service;

import java.util.List;
import java.util.NoSuchElementException;

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
		try {
			return custRepo.findById(id);
		} catch (NoSuchElementException e) {
			log.info("No such Customer which id is: " + id);
			return null;
		}
	}
	
	public Customer findByUserName(String userName) {
		try {
			return custRepo.findByUserName(userName);
		} catch (NoSuchElementException e) {
			log.info("No such Customer which username is: " + userName);
			return null;
		}
	}
	
	public Customer findByEmail(String email) {
		try {
			return custRepo.findByEmail(email);
		} catch (NoSuchElementException e) {
			log.info("No such Customer which email is: " + email);
			return null;
		}
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
			if(findByUserName(obj.getUserName()) != null) {
				custRepo.save(obj);
				return true;
			}
			log.info("Unable to update Customer, Customer doesn't exists");
			return false;
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
