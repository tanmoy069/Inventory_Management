package com.tanmoy.inventory.service;

import java.util.List;

import javax.validation.Valid;

import com.tanmoy.inventory.domain.Invoice;

public class InvoiceService extends AbstractService<Invoice>{

	@Override
	public Invoice findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(@Valid Invoice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(@Valid Invoice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
