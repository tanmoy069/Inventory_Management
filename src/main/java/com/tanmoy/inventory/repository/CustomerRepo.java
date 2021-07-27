package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	Customer findById(int id);
	Customer findByUserName(String userName);

}
