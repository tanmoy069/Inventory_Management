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

@Entity
@Table
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String transDate;
	@NotNull
	private int transType;
	private Double crAmount;
	private Double drAmount;
	@NotNull
	private int productId;
	@NotNull
	private int numberOfProduct;
	@NotNull
	private int customerId;
	@NotNull
	private int userId;
	private Date createDate;
	@NotBlank(message = "Invoice no is mandatory")
	private String invoiceNo;

	public Transactions() {
		super();
	}

	public Transactions(String transDate, int transType, Double crAmount, Double drAmount, int productId,
			int numberOfProduct, int customerId, int userId, String invoiceNo) {
		super();
		this.transDate = transDate;
		this.transType = transType;
		this.crAmount = crAmount;
		this.drAmount = drAmount;
		this.productId = productId;
		this.numberOfProduct = numberOfProduct;
		this.customerId = customerId;
		this.userId = userId;
		this.invoiceNo = invoiceNo;
		this.createDate = Calendar.getInstance().getTime();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public int getTransType() {
		return transType;
	}

	public void setTransType(int transType) {
		this.transType = transType;
	}

	public Double getCrAmount() {
		return crAmount;
	}

	public void setCrAmount(Double crAmount) {
		this.crAmount = crAmount;
	}

	public Double getDrAmount() {
		return drAmount;
	}

	public void setDrAmount(Double drAmount) {
		this.drAmount = drAmount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getNumberOfProduct() {
		return numberOfProduct;
	}

	public void setNumberOfProduct(int numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", transDate=" + transDate + ", transType=" + transType + ", crAmount="
				+ crAmount + ", drAmount=" + drAmount + ", productId=" + productId + ", numberOfProduct="
				+ numberOfProduct + ", customerId=" + customerId + ", userId=" + userId + ", createDate=" + createDate
				+ ", invoiceNo=" + invoiceNo + "]";
	}
	
}
