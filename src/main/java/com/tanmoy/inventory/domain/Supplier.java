package com.tanmoy.inventory.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Supplier", uniqueConstraints = @UniqueConstraint(columnNames = { "primaryPhone", "email" }))
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String companyName;
	@Column(name = "primaryPhone", length = 11)
	private int primaryPhone;
	private int optionalPhone;
	@Column(name = "email", length = 100)
	private String email;
	private String address;
	private int addressCode;
	private Date createdDate;

	public Supplier() {
		super();
	}

	public Supplier(String name, String companyName, int primaryPhone, int optionalPhone, String email,
			String address, int addressCode) {
		super();
		this.name = name;
		this.companyName = companyName;
		this.primaryPhone = primaryPhone;
		this.optionalPhone = optionalPhone;
		this.email = email;
		this.address = address;
		this.addressCode = addressCode;
		this.createdDate = Calendar.getInstance().getTime();
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
		return companyName;
	}

	public void setComapanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(int primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public long getOptionalPhone() {
		return optionalPhone;
	}

	public void setOptionalPhone(int optionalPhone) {
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

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", comapanyName=" + companyName + ", primaryPhone="
				+ primaryPhone + ", optionalPhone=" + optionalPhone + ", email=" + email + ", address=" + address
				+ ", addressCode=" + addressCode + ", createdDate=" + createdDate + "]";
	}
	
}
