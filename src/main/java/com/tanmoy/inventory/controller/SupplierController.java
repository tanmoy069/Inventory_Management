package com.tanmoy.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	private SupplierService suppService;
	
	@Autowired
	public SupplierController(SupplierService suppService) {
		this.suppService = suppService;
	}

}
