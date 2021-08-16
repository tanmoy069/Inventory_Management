package com.tanmoy.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tanmoy.inventory.domain.UserInfo;
import com.tanmoy.inventory.service.UserInfoService;

@Controller
public class InventoryController {
	
	private UserInfoService userInfoService;
	
	@Autowired
	public InventoryController(UserInfoService userInfoSerivce) {
		this.userInfoService = userInfoSerivce;
	}
	
	@GetMapping(value ="/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.isAuthenticated()) auth.setAuthenticated(false);
		return "Login";
	}
	
	@GetMapping(value="/")
	public String redirectHome(Model model) {
		return getHome(model);
	}
	
	@GetMapping(value="/home")
	public String getHome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo user = userInfoService.findByUserName(auth.getName());
		model.addAttribute("userDetails", user);
		model.addAttribute("userId", user.getUserId());
		if(user.getRoleId() == 1) model.addAttribute("isAdmin", true);
		else model.addAttribute("isUser", true);
		return "Home";
	}

}

