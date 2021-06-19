package com.tanmoy.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class ProductType {

	@Id
	@GeneratedValue
	private int id;
	private String typeName;
	private String details;

	public ProductType() {
		super();
	}

	public ProductType(String typeName, String details) {
		super();
		this.typeName = typeName;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", typeName=" + typeName + ", details=" + details + "]";
	}

}
