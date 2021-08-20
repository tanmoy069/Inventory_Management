package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.ProductType;
import com.tanmoy.inventory.service.ProductTypeService;

@RestController
@RequestMapping("/product-type")
public class ProductTypeController {
	
	private ProductTypeService proTypeService;
	
	@Autowired
	public ProductTypeController(ProductTypeService proTypeService) {
		this.proTypeService = proTypeService;
	}
	
	@GetMapping("/findall")
	public List<ProductType> getProductTypeList(){
		return proTypeService.findAll();
	}
	
	

}
