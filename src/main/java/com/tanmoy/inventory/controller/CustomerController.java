package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/findby")
	public Customer getUserByParam(@RequestParam(name="username", required = false) String userName,
			@RequestParam(name="id", required = false) String id,
			@RequestParam(name="email", required = false) String email) {
		if(userName == null && id == null && email == null) return new Customer();
		if(id != null) return custService.findById(custService.getInt(id));
		if(email != null) return custService.findByEmail(email);
		return custService.findByUserName(userName);
	}
	
	@PostMapping("/save")
	public boolean saveCustomer(@RequestBody Customer cust) {
		return custService.save(cust);
	}
	
	@PostMapping("/delete")
	public boolean deleteCustomer(@RequestParam(name = "id", required = true) String id) {
		return custService.deleteById(custService.getInt(id));
	}
	
	@PostMapping("/update")
	public boolean updateCustomer(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "comapanyName", required = false) String comapanyName,
			@RequestParam(name = "primaryPhone", required = false) String primaryPhone,
			@RequestParam(name = "optionalPhone", required = false) String optionalPhone,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "addressCode", required = false) String addressCode,
			@RequestParam(name = "custType", required = false) String custType,
			@RequestParam(name = "userName", required = false) String userName,
			@RequestParam(name = "password", required = false) String password) {
		Customer cust = custService.findById(custService.getInt(id));
		if(cust == null) return false;
		if(name != null) cust.setName(name);
		if(comapanyName != null) cust.setComapanyName(comapanyName);
		if(primaryPhone != null) cust.setPrimaryPhone(custService.getInt(primaryPhone));
		if(optionalPhone != null) cust.setOptionalPhone(custService.getInt(optionalPhone));
		if(email != null) cust.setEmail(email);
		if(address != null) cust.setAddress(address);
		if(addressCode != null) cust.setAddressCode(custService.getInt(addressCode));
		if(custType != null) cust.setCustType(custService.getInt(custType));
		if(userName != null) cust.setUserName(userName);
		if(password != null) cust.setPassword(password);
		return custService.update(cust);
	}

}
