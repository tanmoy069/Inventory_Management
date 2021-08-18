package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.Product;
import com.tanmoy.inventory.domain.UserInfo;
import com.tanmoy.inventory.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/list")
	public List<Product> getProductList() {
		return productService.findAll();
	}
	
	@GetMapping("/findby")
	public UserInfo getUserByParam(@RequestParam(name="username", required = false) String userName,
			@RequestParam(name="userid", required = false) String userId,
			@RequestParam(name="email", required = false) String email) {
		if(userName == null && userId == null && email == null) return new UserInfo();
		if(userId != null) return userInfoService.findById(userInfoService.getInt(userId));
		if(email != null) return userInfoService.findByEmail(email);
		return userInfoService.findByUserName(userName);
	}
}
