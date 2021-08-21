package com.tanmoy.inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tanmoy.inventory.domain.Customer;
import com.tanmoy.inventory.domain.Product;
import com.tanmoy.inventory.domain.ProductType;
import com.tanmoy.inventory.domain.Stock;
import com.tanmoy.inventory.domain.Supplier;
import com.tanmoy.inventory.domain.Transactions;
import com.tanmoy.inventory.domain.UserInfo;
import com.tanmoy.inventory.domain.UserRole;
import com.tanmoy.inventory.repository.CustomerRepo;
import com.tanmoy.inventory.repository.ProductRepo;
import com.tanmoy.inventory.repository.ProductTypeRepo;
import com.tanmoy.inventory.repository.StockRepo;
import com.tanmoy.inventory.repository.SupplierRepo;
import com.tanmoy.inventory.repository.TransactionsRepo;
import com.tanmoy.inventory.repository.UserInfoRepo;
import com.tanmoy.inventory.repository.UserRoleRepo;

@SpringBootTest
class InventoryApplicationTests {

	@Autowired private CustomerRepo custRepo;
	@Autowired private ProductRepo proRepo;
	@Autowired private ProductTypeRepo pTypeRepo;
	@Autowired private StockRepo stockRepo;
	@Autowired private SupplierRepo suppRepo;
	@Autowired private TransactionsRepo transRepo;
	@Autowired private UserInfoRepo userInfoRepo;
	@Autowired private UserRoleRepo roleRepo;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
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
		Product pd = proRepo.findById(10);
		System.out.println(pd.toString());
	}
	
	private Product getProduct() {
		return new Product("Xiaomi Note 5", 1, "Specification\nRAM 3GB and ROM 32GB Version", 15000, 18000);
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
		return new Stock(2, 15, (short)1, null);
	}
	
	@Test
	void addSupplierTest() {
		suppRepo.save(getSupplier());
	}
	
	@Test
	void findSupplierById() {
		Supplier st= suppRepo.findById(1);
		System.out.println(st.toString());
	}
	
	@Test
	void findSupplierByComapyName() {
		List<Supplier> st= suppRepo.findByCompanyNameContains("ABC");
		System.out.println(st.get(0).toString());
	}
	
	private Supplier getSupplier() {
		return new Supplier("Rajib", "ABC Company", 1671234567, 0, null, null, 0);
	}
	
	@Test
	void addTransactionsTest() {
		transRepo.save(getTransactions());
	}
	
	@Test
	void findTransactionsById() {
		Transactions st= transRepo.findById(1);
		System.out.println(st.toString());
	}
	
	@Test
	void findTransactionsByTransDate() {
		List<Transactions> st = null;
		try {
			st = transRepo.findByTransDate(sdf.parse("2021-06-21"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(st.get(0).toString());
	}
	
	@Test
	void findTransactionsByProductId() {
		List<Transactions> st = null;
		st = transRepo.findByProductId(1);
		System.out.println(st.get(0).toString());
	}
	
	@Test
	void findTransactionsByUserId() {
		List<Transactions> st = null;
		st = transRepo.findByUserId(1);
		System.out.println(st.get(0).toString());
	}
	
	@Test
	void findTransactionsByCustomerId() {
		List<Transactions> st = transRepo.findByCustomerId(1);
		System.out.println(st.get(0).toString());
	}
	
	private Transactions getTransactions() {
		try {
			return new Transactions(sdf.parse(sdf.format(Calendar.getInstance().getTime())), 1, 0.0, 15000.0, 1,1,1,1,"INV01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	void addUserInfoTest() {
		userInfoRepo.save(getUserInfo());
	}
	
	@Test
	void findUserInfoByUserId() {
		UserInfo ui= userInfoRepo.findByUserId(1);
		System.out.println(ui.toString());
	}
	
	@Test
	void findUserInfoByRoleId() {
		List<UserInfo> list= userInfoRepo.findByRoleId(1);
		for (UserInfo ui : list) {
			System.out.println(ui.toString());
		}
	}
		
	private UserInfo getUserInfo() {		
		return new UserInfo("tanmoy1", getBycrptPassword("****"), 1, "Tanmoy Tushar", 1762931868, 0, "tanmoy@gmail.com", "Khilkhet, Dhaka", 0, 1);
	}
	
	private String getBycrptPassword(String password) {
		BCryptPasswordEncoder bcryptPassword = new BCryptPasswordEncoder(12);
		return bcryptPassword.encode(password);
	}
	
	@Test
	void addUserRoleTest() {
		roleRepo.save(getUserRole());
	}
	
	@Test
	void findUserRoleByRoleId() {
		UserRole ur = roleRepo.findByRoleId(1);
		System.out.println(ur.toString());
	}
	
	private UserRole getUserRole() {
		return new UserRole("Super Admin", 1, 1, false, true, true, true);
	}

}
