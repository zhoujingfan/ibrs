package com.buptsse.ibrs.dao;

import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.model.UserInfo;

public interface UserInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);
    
    UserInfo selectById(Integer id);

    UserInfo selectByPhoneNumber(String phonenumber);
    
    UserInfo selectByIdNumber(String idNumber);
    
    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    int updateUserInfo(UserInfo record);
    

    int updateMoney(UserInfo record);
}