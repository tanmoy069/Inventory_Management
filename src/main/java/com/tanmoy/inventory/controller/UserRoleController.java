package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanmoy.inventory.domain.UserRole;
import com.tanmoy.inventory.service.UserRoleService;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

	private UserRoleService roleService;
	private ObjectMapper objMapper;

	@Autowired
	public UserRoleController(UserRoleService roleService, ObjectMapper objMapper) {
		this.roleService = roleService;
		this.objMapper = objMapper;
	}

	@GetMapping("/findby")
	public UserRole findUserRoleById(@RequestParam(name = "id", required = true) String id) {
		return roleService.findById(roleService.getInt(id));
	}

	@GetMapping("/findall")
	public List<UserRole> getUserRoleList(@RequestParam(name = "accessType", required = false) String accessType,
			@RequestParam(name = "roleType", required = false) String roleType) {
		if(accessType != null && roleType == null) return roleService.findByAccessType(roleService.getInt(accessType));
		if(accessType == null && roleType != null) return roleService.findByRoleType(roleService.getInt(roleType));
		return roleService.findAll();
	}
	
	@PostMapping("/save")
	public boolean saveUserRole(@RequestBody UserRole role) {
		return roleService.save(role);
	}
	
	@PostMapping("/update")
	public boolean updateUserRole(@RequestParam(name = "roleId", required = true) String roleId,
			@RequestParam(name = "roleName", required = false) String roleName,
			@RequestParam(name = "roleType", required = false) String roleType,
			@RequestParam(name = "accessType", required = false) String accessType,
			@RequestParam(name = "onlyView", required = false) String onlyView,
			@RequestParam(name = "isInsert", required = false) String isInsert,
			@RequestParam(name = "isUpdate", required = false) String isUpdate,
			@RequestParam(name = "isDelete", required = false) String isDelete) {
		UserRole role = roleService.findById(roleService.getInt(roleId));
		if(roleName != null) role.setRoleName(roleName);
		if(roleType != null) role.setRoleType(roleService.getInt(roleType));
		if(accessType != null) role.setAccessType(roleService.getInt(accessType));
		if(onlyView != null) role.setOnlyView(roleService.getBoolean(onlyView));
		if(isInsert != null) role.setIsInsert(roleService.getBoolean(isInsert));
		if(isUpdate != null) role.setIsUpdate(roleService.getBoolean(isUpdate));
		if(isDelete != null) role.setIsDelete(roleService.getBoolean(isDelete));
		return roleService.update(role);
	}
	
	@PostMapping("/delete")
	public boolean deleteUserRole(@RequestParam(name = "roleId", required = true) String roleId) {
		return roleService.deleteById(roleService.getInt(roleId));
	}	

}
