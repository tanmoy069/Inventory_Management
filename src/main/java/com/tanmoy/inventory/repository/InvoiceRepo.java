package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Integer>{
	
	Invoice findById(int id);	
	Invoice findByInvoiceNo(String invoiceNo);

}
