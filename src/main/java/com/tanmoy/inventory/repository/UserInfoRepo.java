package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{

}
