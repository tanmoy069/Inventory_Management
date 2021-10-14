package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
			List<Transactions> list = transService.findByTransDate(transDate);
			if(list.size()>0) return list;
			return transService.findByTransDateContains(transDate);
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
	
	@PostMapping("/save")
	public boolean saveTransactions(@RequestBody Transactions transactions) {
		return transService.save(transactions);
	}
	
	@PostMapping("/delete")
	public boolean deleteTransactions(@RequestParam(name = "id", required = true) String id) {
		return transService.deleteById(transService.getInt(id));
	}
	
	@PostMapping("/update")
	public boolean updateTransactions(@RequestParam(name = "id", required = true) String id,
			@RequestParam(name = "transDate", required = false) String transDate,
			@RequestParam(name = "transType", required = false) String transType,
			@RequestParam(name = "crAmount", required = false) String crAmount,
			@RequestParam(name = "drAmount", required = false) String drAmount,
			@RequestParam(name = "productId", required = false) String productId,
			@RequestParam(name = "numberOfProduct", required = false) String numberOfProduct,
			@RequestParam(name = "customerId", required = false) String customerId,
			@RequestParam(name = "userId", required = false) String userId,
			@RequestParam(name = "invoiceNo", required = false) String invoiceNo) {
		Transactions trans = transService.findById(transService.getInt(id));
		if(trans == null) return false;
		if(transDate != null) trans.setTransDate(transDate);
		if(transType != null) trans.setTransType(transService.getInt(transType));
		if(crAmount != null) trans.setCrAmount(transService.getDouble(crAmount));
		if(drAmount != null) trans.setDrAmount(transService.getDouble(drAmount));
		if(productId != null) trans.setProductId(transService.getInt(productId));
		if(numberOfProduct != null) trans.setNumberOfProduct(transService.getInt(numberOfProduct));
		if(customerId != null) trans.setCustomerId(transService.getInt(customerId));
		if(userId != null) trans.setUserId(transService.getInt(userId));
		if(invoiceNo != null) trans.setInvoiceNo(invoiceNo);
		return transService.update(trans);
	}
	
	
}
