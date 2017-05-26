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
    
    int getMyEnterpriseNum(Integer userId);
    
    int getMyEmployeeNum(Integer id);
    
    List<UserAndEnterprise> getMyEmployee(Integer enterpriseId);
    
    int updateByPrimaryKeySelective(UserAndEnterprise record);

    int deleteFollow(Integer id);
    
    int updateByPrimaryKey(UserAndEnterprise record);
}