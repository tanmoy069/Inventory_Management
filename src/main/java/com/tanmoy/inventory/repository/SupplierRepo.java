package com.tanmoy.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer>{
	
	Supplier findById(int i);
	List<Supplier> findByCompanyNameContains(String companyName);
	List<Supplier> findByNameContains(String name);
	Supplier findByEmail(String email);
	Supplier findByPrimaryPhone(int phone);
	
}
