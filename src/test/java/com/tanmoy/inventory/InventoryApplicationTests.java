package com.tanmoy.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tanmoy.inventory.domain.Customer;
import com.tanmoy.inventory.domain.Product;
import com.tanmoy.inventory.repository.CustomerRepo;
import com.tanmoy.inventory.repository.ProductRepo;

@SpringBootTest
class InventoryApplicationTests {

	
	@Autowired private CustomerRepo custRepo;
	@Autowired private ProductRepo proRepo;
	
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
	
	private Customer getCustomer() {
		Customer ct = new Customer("Apu", "Naztech", 1725768409, 0, 
				"apu.sangma@gmail.com", "Kalachadpur, Dhaka", 0, 0, "apu", "1234");		
		return ct;
	}
	
	@Test
	void addProductTest() {
		proRepo.save(getProduct());
	}
	
	@Test
	void findProductById() {
		Product pd = proRepo.findById(8);
		System.out.println(pd.toString());
	}
	
	private Product getProduct() {
		return new Product("Sony Xperia XA", 1, "Specification\nRAM 2GB and ROM 16GB Version");
	}
	
	

}
