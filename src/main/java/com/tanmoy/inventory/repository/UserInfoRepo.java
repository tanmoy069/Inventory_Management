package com.tanmoy.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{

	UserInfo findByUserId(int userId);
	UserInfo findByUserName(String userName);
	UserInfo findByEmail(String email);
	List<UserInfo> findByRoleId(int roleId);
}
