package com.buptsse.ibrs.dao;

import com.buptsse.ibrs.model.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    
    int updateUserInfoId(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);
    
    User selectByPhoneNumber(long phoneNumber);
    
    User getByPhoneNumber(long phoneNumber);
      
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int updateLoginTime(User record);
    
    
    int updateUser(User record);
}