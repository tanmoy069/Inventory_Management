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
	public List<Transactions> getTransactionsList(@RequestParam(name="userId", required = false) String userId,
			@RequestParam(name="productId", required = false) String productId,
			@RequestParam(name="customerId", required = false) String customerId,
			@RequestParam(name="invoiceNo", required = false) String invoiceNo,
			@RequestParam(name="transDate", required = false) String transDate) {
		if(userId == null && productId == null && customerId == null && invoiceNo == null && transDate != null) {
			return transService.findByTransDate(transDate);
		}
		if(userId == null && productId == null && customerId == null && invoiceNo != null && transDate == null) {
			return transService.findbyInvoiceNo(invoiceNo);
		}
		if(userId == null && productId == null && customerId != null && invoiceNo == null && transDate == null) {
			return transService.findByCustomerId(transService.getInt(customerId));
		}
		if(userId == null && productId != null && customerId == null && invoiceNo == null && transDate == null) {
			return transService.findByProductId(transService.getInt(productId));
		}
		if(userId != null && productId == null && customerId == null && invoiceNo == null && transDate == null) {
			return transService.findByUserId(transService.getInt(userId));
		}
		if(userId == null && productId == null && customerId == null && invoiceNo == null && transDate == null) {
			return transService.findAll();
		}
		return null;
	}
	
	@GetMapping("/findby")
	public Transactions findTransactionsById(@RequestParam(name="id", required = true) String id) {
		return transService.findById(transService.getInt(id));
	}
	
	
}
