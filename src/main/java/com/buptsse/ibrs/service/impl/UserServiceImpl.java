package com.buptsse.ibrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.UserDao;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.UserService;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.dao.UserInfoDao;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(userId);
	}


	@Override
	public void AddUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}


	@Override
	public void SaveUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		userInfoDao.insert(user);
		System.out.println("haha");
		
	}

	@Override
	public User getByPhoneNumber(long phoneNumber) {
		// TODO Auto-generated method stub
		return userDao.selectByPhoneNumber(phoneNumber);
	}


	@Override
	public UserInfo getByIdnumber(String idNumber) {
		// TODO Auto-generated method stub
		return userInfoDao.selectByIdNumber(idNumber);
	}


	@Override
	public void updateLoginTime(User user) {
		// TODO Auto-generated method stub
		userDao.updateLoginTime(user);
	}

}
