package com.tanmoy.inventory.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Stock {

	@Id
	@GeneratedValue
	private int autoId;
	private int productId;
	private int stockNumbers;
	private int stockType;
	private int stockDetails;
	private Date stockInDate;
	private Date stockOutDate;
	
	public Stock() {
		super();
	}

	public Stock(int productId, int stockNumbers, int stockType, int stockDetails, Date stockInDate,
			Date stockOutDate) {
		super();
		this.productId = productId;
		this.stockNumbers = stockNumbers;
		this.stockType = stockType;
		this.stockDetails = stockDetails;
		this.stockInDate = stockInDate;
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

	public int getStockNumbers() {
		return stockNumbers;
	}

	public void setStockNumbers(int stockNumbers) {
		this.stockNumbers = stockNumbers;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public int getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(int stockDetails) {
		this.stockDetails = stockDetails;
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
		return "Stock [autoId=" + autoId + ", productId=" + productId + ", stockNumbers=" + stockNumbers
				+ ", stockType=" + stockType + ", stockDetails=" + stockDetails + ", stockInDate=" + stockInDate
				+ ", stockOutDate=" + stockOutDate + "]";
	}
	
}
