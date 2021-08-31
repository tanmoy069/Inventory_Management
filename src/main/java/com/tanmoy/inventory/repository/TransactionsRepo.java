package com.tanmoy.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Transactions;

public interface TransactionsRepo extends JpaRepository<Transactions, Integer>{
	
	Transactions findById(int id);
	List<Transactions> findByTransDate(String tDate);
	List<Transactions> findByUserId(int userId);
	List<Transactions> findByProductId(int productId);
	List<Transactions> findByCustomerId(int customerId);
	List<Transactions> findByInvoiceNo(String invoiceNo);

}
