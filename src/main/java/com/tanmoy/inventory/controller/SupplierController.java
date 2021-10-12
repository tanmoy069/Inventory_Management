package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/save")
	public boolean saveSupplier(Supplier supplier) {
		return suppService.save(supplier);
	}
	
	@PostMapping("/delete")
	public boolean deleteSupplier(@RequestParam(name = "id", required = true) String id) {
		return suppService.deleteById(suppService.getInt(id));
	}
	
	@PostMapping("/update")
	public boolean updateSupplier(@RequestParam(name = "id", required = true) String id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "companyName", required = false) String companyName,
			@RequestParam(name = "primaryPhone", required = false) String primaryPhone,
			@RequestParam(name = "optionalPhone", required = false) String optionalPhone,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "addressCode", required = false) String addressCode,
			@RequestParam(name = "userId", required = false) String createdDate) {
		Supplier supp = suppService.findById(suppService.getInt(id));
		if(supp == null) return false;
		if(name != null) supp.setName(name);
		if(companyName != null) supp.setComapanyName(companyName);
		if(primaryPhone != null) supp.setPrimaryPhone(suppService.getInt(primaryPhone));
		if(optionalPhone != null) supp.setOptionalPhone(suppService.getInt(optionalPhone));
		if(email != null) supp.setEmail(email);
		if(address != null) supp.setAddress(address);
		if(addressCode != null) supp.setAddressCode(suppService.getInt(addressCode));
		if(createdDate != null) supp.setCreatedDate(suppService.getDate(createdDate));
		return suppService.update(supp);
	}

}
