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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "UserInfo", uniqueConstraints = @UniqueConstraint(columnNames = { "userName", "primaryPhone", "email" }))
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "userName", length = 100)
	@NotBlank(message="username is mandatory")
	private String userName;
	@NotBlank(message="passowrd is mandatory")
	private String password;
	private int roleId;
	@NotBlank(message="Full name is mandatory")
	private String fullNname;
	@Column(name = "primaryPhone", length = 100, nullable = false)
	private int primaryPhone;
	private int optionalPhone;
	@Column(name = "email", length = 100)
	@NotBlank(message="email is mandatory")
	private String email;
	private String address;
	private int addressCode;
	private Date createdDate;
	@NotNull
	private int isActive;
	
	public UserInfo() {
		super();
	}

	public UserInfo(String userName, String password, int roleId, String fullNname, int primaryPhone,
			int optionalPhone, String email, String address, int addressCode, int isActive) {
		super();
		this.userName = userName;
		this.password = getBycrptPassword(password);
		this.roleId = roleId;
		this.fullNname = fullNname;
		this.primaryPhone = primaryPhone;
		this.optionalPhone = optionalPhone;
		this.email = email;
		this.address = address;
		this.addressCode = addressCode;
		this.isActive = isActive;
		this.createdDate = Calendar.getInstance().getTime();
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
		this.password = getBycrptPassword(password);
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
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public int isActive() {
		return isActive;
	}

	public void setActive(int isActive) {
		this.isActive = isActive;
	}
	
	private String getBycrptPassword(String password) {
		BCryptPasswordEncoder bcryptPassword = new BCryptPasswordEncoder(12);
		return bcryptPassword.encode(password);
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", password=" + password + ", roleId=" + roleId
				+ ", fullNname=" + fullNname + ", primaryPhone=" + primaryPhone + ", optionalPhone=" + optionalPhone
				+ ", email=" + email + ", address=" + address + ", addressCode=" + addressCode + ", createdDate="
				+ createdDate + ", isActive=" + isActive + "]";
	}

}
