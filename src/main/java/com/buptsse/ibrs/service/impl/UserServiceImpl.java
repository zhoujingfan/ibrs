package com.buptsse.ibrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.UserDao;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
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

}
