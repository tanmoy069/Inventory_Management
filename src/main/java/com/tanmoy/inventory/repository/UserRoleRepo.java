package com.tanmoy.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.inventory.domain.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer>{

}
