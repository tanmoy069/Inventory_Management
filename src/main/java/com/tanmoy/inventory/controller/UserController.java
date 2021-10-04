package com.tanmoy.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.inventory.domain.UserInfo;
import com.tanmoy.inventory.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserInfoService userInfoService;
	
	@Autowired
	public UserController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	@GetMapping("/list")
	public List<UserInfo> getUserList() {
		return userInfoService.findAll();
	}
	
	@GetMapping("/findby")
	public UserInfo getUserByParam(@RequestParam(name="username", required = false) String userName,
			@RequestParam(name="userid", required = false) String userId,
			@RequestParam(name="email", required = false) String email) {
		if(userName == null && userId == null && email == null) return new UserInfo();
		if(userId != null) return userInfoService.findById(userInfoService.getInt(userId));
		if(email != null) return userInfoService.findByEmail(email);
		return userInfoService.findByUserName(userName);
	}
	
	@PostMapping("/delete")
	public boolean deleteUser(@RequestParam(name = "roleId", required = true) String roleId) {
		return userInfoService.deleteById(userInfoService.getInt(roleId));
	}

}
