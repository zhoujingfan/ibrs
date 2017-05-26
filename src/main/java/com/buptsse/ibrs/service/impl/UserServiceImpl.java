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
	
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(userId);
	}


	public void AddUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}


	public void SaveUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		userInfoDao.insert(user);
		System.out.println("haha");
		
	}

	public User getByPhoneNumber(long phoneNumber) {
		// TODO Auto-generated method stub
		
		User user = userDao.getByPhoneNumber(phoneNumber);
		if(user == null)
			return userDao.selectByPhoneNumber(phoneNumber);
		else
			return userDao.getByPhoneNumber(phoneNumber);
	}


	public UserInfo getByIdnumber(String idNumber) {
		// TODO Auto-generated method stub
		return userInfoDao.selectByIdNumber(idNumber);
	}


	public void updateLoginTime(User user) {
		// TODO Auto-generated method stub
		userDao.updateLoginTime(user);
	}


	public void saveIdentification(User user) {
		// TODO Auto-generated method stub
		UserInfo userInfo = userInfoDao.selectByIdNumber(user.getUserInfo().getIdNumber());
		if(userInfo == null){
			userInfo = user.getUserInfo();
			userInfoDao.insert(userInfo);
			userInfo = userInfoDao.selectByIdNumber(user.getUserInfo().getIdNumber());
			user.setUserInfo(userInfo);
			userDao.updateUserInfoId(user);
		}
		else
		{
			user.setUserInfo(userInfoDao.selectByIdNumber(user.getUserInfo().getIdNumber()));
			userDao.updateUserInfoId(user);
		}
	}


	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
		userInfoDao.updateUserInfo(user.getUserInfo());
		
	}


	@Override
	public void updateMoney(User user) {
		// TODO Auto-generated method stub
		userInfoDao.updateMoney(user.getUserInfo());
	}


	@Override
	public UserInfo getById(Integer id) {
		// TODO Auto-generated method stub
		return userInfoDao.selectById(id);
	}

}
