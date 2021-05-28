package com.tanmoy.inventory.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private int productName;
	private int productType;
	private int details;
	private Date createdDate;

	public Product(int productName, int productType, int details) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductName() {
		return productName;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getDetails() {
		return details;
	}

	public void setDetails(int details) {
		this.details = details;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
