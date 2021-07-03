package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.UserInfo;
import com.tanmoy.inventory.service.UserInfoService;

@RestController()
@RequestMapping("/user")
public class UserController {
	
	private UserInfoService userInfoService;
	
	@Autowired
	public UserController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	@RequestMapping("/list")
	public List<UserInfo> getUserList() {
		return userInfoService.findAll();
	}	

}
