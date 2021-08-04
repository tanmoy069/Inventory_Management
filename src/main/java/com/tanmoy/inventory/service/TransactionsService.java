package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.Transactions;

@Service
public class TransactionsService extends AbstractService<Transactions>{

	@Override
	public Transactions findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Transactions obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Transactions obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
