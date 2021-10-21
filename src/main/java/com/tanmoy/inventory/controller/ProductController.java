package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/save")
	public boolean saveProduct(@RequestBody Product product) {
		return productService.save(product);
	}

}
