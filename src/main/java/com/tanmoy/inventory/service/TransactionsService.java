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
			return null;
		}
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
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Transactions obj) {
		try {
			transRepo.save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			transRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
