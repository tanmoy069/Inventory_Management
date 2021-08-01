package com.tanmoy.inventory.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	@NotBlank(message="Product name is mandatory")
	@NotNull
	private int productType;
	private String details;
	private double purchaseValue;
	private double sellingValue;
	private Date createdDate;
	
	public Product() {
		super();
	}

	public Product(String productName, int productType, String details, double purchaseValue, double sellingValue) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.details = details;
		this.purchaseValue = purchaseValue;
		this.sellingValue = sellingValue;
		this.createdDate = Calendar.getInstance().getTime();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public double getSellingValue() {
		return sellingValue;
	}

	public void setSellingValue(double sellingValue) {
		this.sellingValue = sellingValue;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productType=" + productType + ", details="
				+ details + ", purchaseValue=" + purchaseValue + ", sellingValue=" + sellingValue + ", createdDate="
				+ createdDate + "]";
	}

}
