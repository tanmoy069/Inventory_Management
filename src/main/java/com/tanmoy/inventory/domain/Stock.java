package com.tanmoy.inventory.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int autoId;
	@Column(unique = true, nullable = false)
	private int productId;
	@NotNull
	@Min(0)
	private int availableStocks;
	@Min(0)	@Max(1)
	private short isStockUpdate;
	private Date stockInDate;
	private Date stockOutDate;

	public Stock() {
		super();
	}

	public Stock(int productId, int availableStocks, short isStockUpdate, Date stockOutDate) {
		super();
		this.productId = productId;
		this.availableStocks = availableStocks;
		this.isStockUpdate = isStockUpdate;
		this.stockInDate = Calendar.getInstance().getTime();
		this.stockOutDate = stockOutDate;
	}

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAvailableStocks() {
		return availableStocks;
	}

	public void setAvailableStocks(int availableStocks) {
		this.availableStocks = availableStocks;
	}

	public short isStockUpdate() {
		return isStockUpdate;
	}

	public void setStockUpdate(short isStockUpdate) {
		this.isStockUpdate = isStockUpdate;
	}

	public Date getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}

	public Date getStockOutDate() {
		return stockOutDate;
	}

	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
	}

	@Override
	public String toString() {
		return "Stock [autoId=" + autoId + ", productId=" + productId + ", availableStocks=" + availableStocks
				+ ", isStockUpdate=" + isStockUpdate + ", stockInDate=" + stockInDate + ", stockOutDate=" + stockOutDate
				+ "]";
	}

}
