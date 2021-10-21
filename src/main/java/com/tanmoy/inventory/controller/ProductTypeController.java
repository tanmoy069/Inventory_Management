package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<ProductType> getProductTypeList() {
		return proTypeService.findAll();
	}

	@GetMapping("/findby")
	public ProductType getProductById(@RequestParam(name = "id", required = false) String id) {
		return proTypeService.findById(proTypeService.getInt(id));
	}

	@PostMapping("/save")
	public boolean saveProductType(@RequestBody ProductType productType) {
		return proTypeService.save(productType);
	}
	
	@PostMapping("/delete")
	public boolean deleteProductType(@RequestParam(name = "id", required = true) String id) {
		return proTypeService.deleteById(proTypeService.getInt(id));
	}
	
	@PostMapping("/update")
	public boolean updateProductType(@RequestParam(name = "id", required = true) String id,
			@RequestParam(name = "typeName", required = false) String typeName,
			@RequestParam(name = "details", required = false) String details) {
		ProductType proType = proTypeService.findById(proTypeService.getInt(id));
		if(proType == null) return false;
		if(typeName != null) proType.setTypeName(typeName);
		if(details != null) proType.setDetails(details);		
		return proTypeService.update(proType);
	}

}
