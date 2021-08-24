package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.Transactions;
import com.tanmoy.inventory.service.TransactionsService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

	private TransactionsService transService;

	@Autowired
	public TransactionsController(TransactionsService transService) {
		this.transService = transService;
	}
	
	@GetMapping("/findall")
	public List<Transactions> getTransactionsList() {
		return transService.findAll();
	}
	
	@GetMapping("/findby")
	public Transactions findTransactionsById(@RequestParam(name="id", required = true) String id) {
		return transService.findById(transService.getInt(id));
	}
	
	
}
