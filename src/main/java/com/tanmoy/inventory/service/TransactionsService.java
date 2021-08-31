package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.Transactions;
import com.tanmoy.inventory.repository.TransactionsRepo;

@Service
public class TransactionsService extends AbstractService<Transactions> {

	private TransactionsRepo transRepo;

	@Autowired
	public TransactionsService(TransactionsRepo transRepo) {
		this.transRepo = transRepo;
	}

	@Override
	public Transactions findById(int id) {
		try {
			return transRepo.findById(id);
		} catch (Exception e) {
			log.info("No such Transactions which id is: " + id);
			return null;
		}
	}

	public List<Transactions> findByTransDate(String transDate) {
		return transRepo.findByTransDate(transDate);
	}
	
	public List<Transactions> findByTransDateContains(String transDate) {
		return transRepo.findByTransDateContains(transDate);
	}

	public List<Transactions> findByUserId(int userId) {
		return transRepo.findByUserId(userId);
	}

	public List<Transactions> findByProductId(int productId) {
		return transRepo.findByProductId(productId);
	}

	public List<Transactions> findByCustomerId(int customerId) {
		return transRepo.findByCustomerId(customerId);
	}

	public List<Transactions> findbyInvoiceNo(String invoiceNo) {
		return transRepo.findByInvoiceNo(invoiceNo);
	}

	@Override
	public List<Transactions> findAll() {
		return transRepo.findAll();
	}

	@Override
	public boolean save(Transactions obj) {
		try {
			if (findById(obj.getId()) == null) {
				transRepo.save(obj);
				return true;
			}
			log.info("Already exists Transactions");
			return false;
		} catch (Exception e) {
			log.info("Failed to save Transactions due to " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Transactions obj) {
		try {
			transRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to update Transactions's id: " + obj.getId() + "  due to " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			transRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete Transactions's id: " + id + "  due to " + e.getMessage());
			return false;
		}
	}

}
