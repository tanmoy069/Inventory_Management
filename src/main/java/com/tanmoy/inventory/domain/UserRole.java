package com.tanmoy.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserRole {

	@Id
	@GeneratedValue
	private int roleId;
	private String roleName;
	private int roleType;
	private int accessType;
	private int onlyView;
	private int isInsert;
	private int isUpdate;
	private int isDelete;

	public UserRole(String roleName, int roleType, int accessType, int onlyView, int isInsert, int isUpdate,
			int isDelete) {
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

	public int getOnlyView() {
		return onlyView;
	}

	public void setOnlyView(int onlyView) {
		this.onlyView = onlyView;
	}

	public int getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(int isInsert) {
		this.isInsert = isInsert;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
