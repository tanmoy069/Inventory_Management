package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.Supplier;
import com.tanmoy.inventory.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	private SupplierService suppService;
	
	@Autowired
	public SupplierController(SupplierService suppService) {
		this.suppService = suppService;
	}
	
	@GetMapping("/findall")
	public List<Supplier> getSupplierList(){
		return suppService.findAll();
	}

}
