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
	
	@PostMapping("/save")
	public boolean saveUser(UserInfo user) {
		return userInfoService.save(user);
	}
	
	@PostMapping("/delete")
	public boolean deleteUser(@RequestParam(name = "userId", required = true) String userId) {
		return userInfoService.deleteById(userInfoService.getInt(userId));
	}
	
	@PostMapping("/update")
	public boolean updateUser(@RequestParam(name = "userId", required = true) String userId,
			@RequestParam(name = "password", required = false) String password,
			@RequestParam(name = "roleId", required = false) String roleId,
			@RequestParam(name = "fullName", required = false) String fullName,
			@RequestParam(name = "primaryPhone", required = false) String primaryPhone,
			@RequestParam(name = "optionalPhone", required = false) String optionalPhone,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "addressCode", required = false) String addressCode) {
		UserInfo user = userInfoService.findById(userInfoService.getInt(userId));
		if(user == null) return false;
		if(password != null) user.setPassword(password);
		if(roleId != null) user.setRoleId(userInfoService.getInt(roleId));
		if(fullName != null) user.setFullName(fullName);
		if(primaryPhone != null) user.setPrimaryPhone(userInfoService.getInt(primaryPhone));
		if(optionalPhone != null) user.setOptionalPhone(userInfoService.getInt(optionalPhone));
		if(email != null) user.setEmail(email);
		if(address != null) user.setAddress(address);
		if(addressCode != null) user.setAddressCode(userInfoService.getInt(addressCode));
		return userInfoService.update(user);
	}

}
