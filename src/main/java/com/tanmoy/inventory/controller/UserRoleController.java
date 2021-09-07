package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
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
	
	@GetMapping("/test")
	public UserRole validateUserRoleModel(UserRole role){
		System.out.println(role.toString());
		return role;
	}

}
