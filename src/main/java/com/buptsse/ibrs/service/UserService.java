package com.buptsse.ibrs.service;

import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.model.UserInfo;

public interface UserService {
	/**
	 * 通过Id查询用户
	 * @param userId
	 * @return User
	 */
	User getById(int userId);
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */

	UserInfo getByIdnumber(String idNumber);
	
	User getByPhoneNumber(long phoneNumber);
	
	void AddUser(User user);

	void SaveUserInfo(UserInfo userInfo);
	
	void updateLoginTime(User user);
	
	void saveIdentification(User user);
	
	void updateUser(User user);
	
	UserInfo getById(Integer id);
	void updateMoney(User user);

}
