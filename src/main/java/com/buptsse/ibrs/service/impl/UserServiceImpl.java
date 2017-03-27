package com.buptsse.ibrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.UserDao;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.UserService;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.dao.UserInfoMapper;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	UserInfoMapper userInfoDao;
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(userId);
	}

	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}

	@Override
	public void AddUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public UserInfo getByPhoneNumber(String number) {
		// TODO Auto-generated method stub
		
		return userInfoDao.selectByPhoneNumber(number);
	}

	@Override
	public void SavaUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		userInfoDao.insert(user);
		
	}

	@Override
	public UserInfo getUserInfoById(Integer id) {
		// TODO Auto-generated method stub
		
		return userInfoDao.selectByPrimaryKey(id);
	}

	@Override
	public UserInfo getUserInfoByUsername(String username) {
		// TODO Auto-generated method stub
		User user  = userDao.selectByUsername(username);
		
		return userInfoDao.selectByPrimaryKey(user.getUserid());
	}

}
