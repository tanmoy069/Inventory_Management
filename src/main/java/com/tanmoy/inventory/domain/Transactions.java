package com.tanmoy.inventory.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transactions {

	@Id
	@GeneratedValue
	private int id;
	private Date transDate;
	private int transType;
	private Double crAmount;
	private Double drAmount;
	private int productId;
	private int numberOfProduct;
	private int custSuppId;
	private int userId;
	private Date createDate;
	private int invoiceNo;

	public Transactions(Date transDate, int transType, Double crAmount, Double drAmount, int productId,
			int numberOfProduct, int custSuppId, int userId, int invoiceNo) {
		super();
		this.transDate = transDate;
		this.transType = transType;
		this.crAmount = crAmount;
		this.drAmount = drAmount;
		this.productId = productId;
		this.numberOfProduct = numberOfProduct;
		this.custSuppId = custSuppId;
		this.userId = userId;
		this.invoiceNo = invoiceNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
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

	public int getCustSuppId() {
		return custSuppId;
	}

	public void setCustSuppId(int custSuppId) {
		this.custSuppId = custSuppId;
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

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

}
