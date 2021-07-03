package com.tanmoy.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.inventory.domain.UserInfo;
import com.tanmoy.inventory.repository.UserInfoRepo;

@Service
public class UserInfoService extends AbstractService<UserInfo> {

	private UserInfoRepo userInfoRepo;

	@Autowired
	public UserInfoService(UserInfoRepo userInfoRepo) {
		this.userInfoRepo = userInfoRepo;
	}

	@Override
	public UserInfo findById(int id) {
		return userInfoRepo.findByUserId(id);
	}
	
	public UserInfo findByUserName(String userName) {
		return userInfoRepo.findByUserName(userName);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoRepo.findAll();
	}

	@Override
	public boolean save(UserInfo obj) {
		try {
			userInfoRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to insert user-" + obj.getUserId() + " to UserInfo");
			return false;
		}
	}

	@Override
	public boolean update(UserInfo obj) {
		try {
			userInfoRepo.save(obj);
			return true;
		} catch (Exception e) {
			log.info("Failed to update id-" + obj.getUserId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			userInfoRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.info("Failed to delete id-" + id + " from UserInfo");
			return false;
		}
	}

}
