package com.tanmoy.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer>{
	
	UserRole findByRoleId(int roleId);
	List<UserRole> findByRoleType(int roleType);
	List<UserRole> findByAccessType(int accessType);

}
