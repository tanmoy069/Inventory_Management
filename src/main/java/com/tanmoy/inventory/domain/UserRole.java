package com.tanmoy.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	@NotBlank(message="Role name is mandatory")
	private String roleName;
	@NotNull
	private int roleType;
	@NotNull
	private int accessType;
	@NotNull
	private boolean onlyView;
	@NotNull
	private boolean isInsert;
	@NotNull
	private boolean isUpdate;
	@NotNull
	private boolean isDelete;

	public UserRole() {
		super();
	}

	public UserRole(String roleName, int roleType, int accessType, boolean onlyView, boolean isInsert, boolean isUpdate,
			boolean isDelete) {
		super();
		this.roleName = roleName;
		this.roleType = roleType;
		this.accessType = accessType;
		this.onlyView = onlyView;
		this.isInsert = isInsert;
		this.isUpdate = isUpdate;
		this.isDelete = isDelete;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}

	public boolean getOnlyView() {
		return onlyView;
	}

	public void setOnlyView(boolean onlyView) {
		this.onlyView = onlyView;
	}

	public boolean getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(boolean isInsert) {
		this.isInsert = isInsert;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + ", roleType=" + roleType + ", accessType="
				+ accessType + ", onlyView=" + onlyView + ", isInsert=" + isInsert + ", isUpdate=" + isUpdate
				+ ", isDelete=" + isDelete + "]";
	}
	
}
