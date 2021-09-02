package com.tanmoy.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.UserRole;
import com.tanmoy.inventory.service.UserRoleService;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

	private UserRoleService roleService;
	
	@Autowired
	public UserRoleController(UserRoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping("/findby")
	public UserRole findTransactionsById(@RequestParam(name="id", required = true) String id) {
		return roleService.findById(roleService.getInt(id));
	}	
	
}
