package com.tanmoy.inventory.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.Invoice;
import com.tanmoy.inventory.repository.InvoiceRepo;

@Service
public class InvoiceService extends AbstractService<Invoice> {

	private InvoiceRepo invoiceRepo;

	@Autowired
	public InvoiceService(InvoiceRepo invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}

	@Override
	public Invoice findById(int id) {
		try {
			return invoiceRepo.findById(id);
		} catch (NoSuchElementException e) {
			log.info("No such Invoice which id is: " + id);
			return null;
		}
	}

	@Override
	public List<Invoice> findAll() {
		return invoiceRepo.findAll();
	}

	@Override
	public boolean save(@Valid Invoice obj) {
		try {
			if (findById(obj.getId()) == null) {
				invoiceRepo.save(obj);
				return true;
			}
			log.info("Invoice already exists");
			return false;
		} catch (Exception e) {
			log.info("Failed to insert ivoice id -" + obj.getId() + " to Invoice");
			return false;
		}
	}

	@Override
	public boolean update(@Valid Invoice obj) {
		try {
			invoiceRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to update Invoice id-" + obj.getId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			invoiceRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete Invoice id-" + id);
			return false;
		}
	}

}
