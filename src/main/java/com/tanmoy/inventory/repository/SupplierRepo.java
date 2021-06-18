package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer>{

}
