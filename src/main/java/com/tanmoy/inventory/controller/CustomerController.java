package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.Customer;
import com.tanmoy.inventory.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService custService;
	
	@Autowired
	public CustomerController(CustomerService custService) {
		this.custService = custService;
	}
	
	@GetMapping("/findall")
	public List<Customer> getAllCustomer() {
		return custService.findAll();
	}

}
