package com.tanmoy.inventory.secutiry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.UserInfo;
import com.tanmoy.inventory.service.UserInfoService;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	private UserInfoService userInfoService;

	@Autowired
	public UserDetailsServiceImplements(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = userInfoService.findByUserName(username);
		List<GrantedAuthority> authorities = getUserAuthority();
		return buildUserForAuthentication(user, authorities);
	}

	private UserDetails buildUserForAuthentication(UserInfo user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,
				true, true, true, authorities);
	}

	private List<GrantedAuthority> getUserAuthority() {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("super"));
		roles.add(new SimpleGrantedAuthority("admin"));
		roles.add(new SimpleGrantedAuthority("user"));
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

}
