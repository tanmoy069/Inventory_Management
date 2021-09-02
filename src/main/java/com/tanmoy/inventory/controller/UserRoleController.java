package com.tanmoy.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.service.UserRoleService;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

	private UserRoleService roleService;
	
	@Autowired
	public UserRoleController(UserRoleService roleService) {
		this.roleService = roleService;
	}
}
