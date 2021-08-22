package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Supplier> getSupplierList(@RequestParam(name="name", required = false) String name,
			@RequestParam(name="companyName", required = false) String companyName){
		if(name == null && companyName == null) return suppService.findAll();
		if(name == null && companyName != null) return suppService.findByCompanyNameContains(companyName);
		return suppService.findByNameContains(name);
	}
	
	@GetMapping("/findby")
	public Supplier getSupplierByParam(@RequestParam(name="id", required = false) String id,
			@RequestParam(name="phone", required = false) String phone,
			@RequestParam(name="email", required = false) String email){
		if(id == null && phone == null && email == null) return null;
		if(id == null && phone == null) return suppService.findByEmail(email);
		if(id == null && email == null) return suppService.findByPhone(suppService.getInt(phone));
		return suppService.findById(suppService.getInt(id));
	}

}
