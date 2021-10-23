package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.Product;
import com.tanmoy.inventory.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/findall")
	public List<Product> getProductList(@RequestParam(name = "producttype", required = false) String type) {
		if (type == null) return productService.findAll();
		return productService.findByProductType(productService.getInt(type));
	}

	@GetMapping("/findby")
	public Product getProduct(@RequestParam(name = "id", required = false) String id) {
		if (id == null) return new Product();
		return productService.findById(productService.getInt(id));
	}
	
	@PostMapping("/save")
	public boolean saveProduct(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@PostMapping("/delete")
	public boolean deleteProduct(@RequestParam(name = "id", required = false) String id) {
		return productService.deleteById(productService.getInt(id));
	}
	
	@PostMapping("/update")
	public boolean updateProduct(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "productName", required = false) String productName,
			@RequestParam(name = "productType", required = false) String productType,
			@RequestParam(name = "details", required = false) String details,
			@RequestParam(name = "purchaseValue", required = false) String purchaseValue,
			@RequestParam(name = "sellingValue", required = false) String sellingValue) {
		Product pro = productService.findById(productService.getInt(id));
		if(pro == null) return false;
		if(productName != null) pro.setProductName(productName);
		if(productType != null) pro.setProductType(productService.getInt(productType));
		if(details != null) pro.setDetails(details);
		if(purchaseValue != null) pro.setPurchaseValue(productService.getDouble(purchaseValue));
		if(sellingValue != null) pro.setSellingValue(productService.getDouble(sellingValue));
		return productService.update(pro);
	}

}
