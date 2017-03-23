package com.buptsse.ibrs.dao;

import com.buptsse.ibrs.model.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);
      
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}