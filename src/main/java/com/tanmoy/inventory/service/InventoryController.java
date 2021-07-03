package com.tanmoy.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tanmoy.inventory.domain.UserInfo;

@Controller
public class InventoryController {
	
	private UserInfoService userInfoService;
	
	@Autowired
	public InventoryController(UserInfoService userInfoSerivce) {
		this.userInfoService = userInfoSerivce;
	}
	
	@GetMapping(value ="/login")
	public String login() {
		return "Login";
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

