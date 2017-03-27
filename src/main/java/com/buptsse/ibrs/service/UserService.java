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
	User getByUsername(String username);
	void AddUser(User user);

	void SavaUserInfo(UserInfo user);
	UserInfo getByPhoneNumber(String number);
	
	UserInfo getUserInfoById(Integer id);
	
	UserInfo getUserInfoByUsername(String Username);
}
