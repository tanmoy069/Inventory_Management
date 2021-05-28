package com.tanmoy.inventory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Supplier", uniqueConstraints = @UniqueConstraint(columnNames = { "primaryPhone", "email" }))
public class Supplier {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String comapanyName;
	@Column(name = "primaryPhone", length = 11)
	private long primaryPhone;
	private long optionalPhone;
	@Column(name = "email", length = 100)
	private String email;
	private String address;
	private int addressCode;
	private Date createdDate;

	public Supplier(String name, String comapanyName, long primaryPhone, long optionalPhone, String email,
			String address, int addressCode) {
		super();
		this.name = name;
		this.comapanyName = comapanyName;
		this.primaryPhone = primaryPhone;
		this.optionalPhone = optionalPhone;
		this.email = email;
		this.address = address;
		this.addressCode = addressCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComapanyName() {
		return comapanyName;
	}

	public void setComapanyName(String comapanyName) {
		this.comapanyName = comapanyName;
	}

	public long getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(long primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public long getOptionalPhone() {
		return optionalPhone;
	}

	public void setOptionalPhone(long optionalPhone) {
		this.optionalPhone = optionalPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(int addressCode) {
		this.addressCode = addressCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
