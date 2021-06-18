package com.tanmoy.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tanmoy.inventory.domain.Customer;
import com.tanmoy.inventory.repository.CustomerRepo;

@SpringBootTest
class InventoryApplicationTests {

	
	@Autowired private CustomerRepo custRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void addCustomerTest() {
		custRepo.save(getCustomer());
	}
	
	@Test
	void findCustomerByUserName() {
		Customer ct = custRepo.findByUserName("apu");
		System.out.println(ct.toString());
	}
	
	
	
	public Customer getCustomer() {
		Customer ct = new Customer("Apu", "Naztech", 1725768409, 0, 
				"apu.sangma@gmail.com", "Kalachadpur, Dhaka", 0, 0, "apu", "1234");		
		return ct;
	}

}
