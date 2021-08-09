package com.tanmoy.inventory.domain;

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
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Invoice no is mandatory")
	private String invoiceNo;
	@NotNull
	private Date transDate;
	private double payment;
	private double due;
	private double discount;
	private int totalProducts;
	private int quantity;

	public Invoice() {
		super();
	}

	public Invoice(@NotBlank(message = "Invoice no is mandatory") String invoiceNo, @NotNull Date transDate,
			double payment, double due, double discount, int totalProducts, int quantity) {
		super();
		this.invoiceNo = invoiceNo;
		this.transDate = transDate;
		this.payment = payment;
		this.due = due;
		this.discount = discount;
		this.totalProducts = totalProducts;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		this.due = due;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoiceNo=" + invoiceNo + ", transDate=" + transDate + ", payment=" + payment
				+ ", due=" + due + ", discount=" + discount + ", totalProducts=" + totalProducts + ", quantity="
				+ quantity + "]";
	}

}
