package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.UserRole;
import com.tanmoy.inventory.repository.UserRoleRepo;

@Service
public class UserRoleService extends AbstractService<UserRole> {

	private UserRoleRepo roleRepo;
	
	@Autowired
	public UserRoleService(UserRoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	@Override
	public UserRole findById(int id) {
		return roleRepo.findByRoleId(id);
	}
	
	public List<UserRole> findByRoleType(int roleType){
		return roleRepo.findByRoleType(roleType);
	}
	
	public List<UserRole> findByAccessType(int accessType){
		return roleRepo.findByAccessType(accessType);
	}

	@Override
	public List<UserRole> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public boolean save(UserRole obj) {
		try {
			if(roleRepo.findByRoleId(obj.getRoleId()) == null) {
				roleRepo.save(obj);
				return true;
			}
			log.info("User role already exist which roleId is : " + obj.getRoleId());
			return false;
		} catch (Exception e) {
			log.info("Failed to insert user role-" + obj.getRoleId() + " to UserRole");
			return false;
		}
	}

	@Override
	public boolean update(UserRole obj) {
		try {
			if(roleRepo.findById(obj.getRoleId()) != null) {
				roleRepo.save(obj);
				return true;
			}
			log.info("Unable to update, because user role dosen't exits");
			return false;
		} catch (Exception e) {
			log.info("Failed to update id-" + obj.getRoleId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			roleRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete id-" + id + " from UserInfo");
			return false;
		}
	}

}
