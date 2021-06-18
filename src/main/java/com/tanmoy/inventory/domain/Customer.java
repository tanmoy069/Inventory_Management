package com.tanmoy.inventory.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Customer", uniqueConstraints = @UniqueConstraint(columnNames = { "primaryPhone", "email", "userName" }))
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String comapanyName;
	@Column(name = "primaryPhone", length = 11)
	private int primaryPhone;
	private int optionalPhone;
	@Column(name = "email", length = 100)
	private String email;
	private String address;
	private int addressCode;
	private int custType;
	@Column(name = "userName", length = 50)
	private String userName;
	private String password;
	private Date createdDate;
	
	public Customer() {
		super();
	}

	public Customer(String name, String comapanyName, int primaryPhone, int optionalPhone, String email,
			String address, int addressCode, int custType, String userName, String password) {
		super();
		this.name = name;
		this.comapanyName = comapanyName;
		this.primaryPhone = primaryPhone;
		this.optionalPhone = optionalPhone;
		this.email = email;
		this.address = address;
		this.addressCode = addressCode;
		this.custType = custType;
		this.userName = userName;
		this.password = password;
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
		return comapanyName;
	}

	public void setComapanyName(String comapanyName) {
		this.comapanyName = comapanyName;
	}

	public int getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(int primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public int getOptionalPhone() {
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

	public int getCustType() {
		return custType;
	}

	public void setCustType(int custType) {
		this.custType = custType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", comapanyName=" + comapanyName + ", primaryPhone="
				+ primaryPhone + ", optionalPhone=" + optionalPhone + ", email=" + email + ", address=" + address
				+ ", addressCode=" + addressCode + ", custType=" + custType + ", userName=" + userName + ", password="
				+ password + ", createdDate=" + createdDate + "]";
	}
	
}
