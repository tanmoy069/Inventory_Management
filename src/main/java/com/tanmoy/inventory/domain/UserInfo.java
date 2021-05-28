package com.tanmoy.inventory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UserInfo", uniqueConstraints = @UniqueConstraint(columnNames = { "primaryPhone", "email" }))
public class UserInfo {
	
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String password;
	private int roleId;
	private String fullNname;
	@Column(name = "primaryPhone", length = 100)
	private long primaryPhone;
	private long optionalPhone;
	@Column(name = "email", length = 100)
	private String email;
	private String address;
	private int addressCode;
	private Date createdDate;
	
	public UserInfo(String userName, String password, int roleId, String fullNname, long primaryPhone,
			long optionalPhone, String email, String address, int addressCode) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.fullNname = fullNname;
		this.primaryPhone = primaryPhone;
		this.optionalPhone = optionalPhone;
		this.email = email;
		this.address = address;
		this.addressCode = addressCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getFullNname() {
		return fullNname;
	}

	public void setFullNname(String fullNname) {
		this.fullNname = fullNname;
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
