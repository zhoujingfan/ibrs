package com.buptsse.ibrs.dao;

import java.util.List;

import com.buptsse.ibrs.model.UserAndEnterprise;

public interface UserAndEnterpriseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndEnterprise record);

    int insertSelective(UserAndEnterprise record);

    UserAndEnterprise selectByPrimaryKey(Integer id);
    
    UserAndEnterprise selectByEnterpriseId(Integer id);

    UserAndEnterprise selectFollow(UserAndEnterprise record);
    
    List<UserAndEnterprise> getMyEnterprise(Integer userId);
    
    List<UserAndEnterprise> getMyEmployee(Integer enterpriseId);
    
    int updateByPrimaryKeySelective(UserAndEnterprise record);

    int updateByPrimaryKey(UserAndEnterprise record);
}