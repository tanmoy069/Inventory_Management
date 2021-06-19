package com.tanmoy.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tanmoy.inventory.domain.Customer;
import com.tanmoy.inventory.domain.Product;
import com.tanmoy.inventory.domain.ProductType;
import com.tanmoy.inventory.domain.Stock;
import com.tanmoy.inventory.repository.CustomerRepo;
import com.tanmoy.inventory.repository.ProductRepo;
import com.tanmoy.inventory.repository.ProductTypeRepo;
import com.tanmoy.inventory.repository.StockRepo;

@SpringBootTest
class InventoryApplicationTests {

	
	@Autowired private CustomerRepo custRepo;
	@Autowired private ProductRepo proRepo;
	@Autowired private ProductTypeRepo pTypeRepo;
	@Autowired private StockRepo stockRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void addCustomerTest() {
		custRepo.save(getCustomer());
	}
	
	@Test
	void findCustomerByUserName() {
		Customer ct = custRepo.findByUserName("shaon");
		System.out.println(ct.toString());
	}	
	
	private Customer getCustomer() {
		Customer ct = new Customer("Shaon", "IHT", 1685094300, 0, 
				"mohaiminul.islam@gmail.com", "Gopalpur, Tangail", 0, 0, "shaon", "1234");		
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
	
	@Test
	void addProductTypeTest() {
		pTypeRepo.save(getProductType());
	}
	
	@Test
	void findProductTypeById() {
		ProductType pdt= pTypeRepo.findById(1);
		System.out.println(pdt.toString());
	}
	
	private ProductType getProductType() {
		return new ProductType("Smart TV", "All types of smart television are under this type");
	}
	
	@Test
	void addStockTest() {
		stockRepo.save(getStock());
	}
	
	@Test
	void findStockByProductId() {
		Stock st= stockRepo.findByProductId(1);
		System.out.println(st.toString());
	}
	
	private Stock getStock() {
		return new Stock(1, 10, false, null);
	}	

}
