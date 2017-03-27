package com.buptsse.ibrs.dao;

import java.util.List;

import com.buptsse.ibrs.model.UserAndEnterprise;

public interface UserAndEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndEnterprise record);

    int insertSelective(UserAndEnterprise record);

    UserAndEnterprise selectByPrimaryKey(Integer id);
    
    UserAndEnterprise selectByEnterpriseId(Integer id);

    List<UserAndEnterprise> getMyEnterprise(Integer userId);
    
    int updateByPrimaryKeySelective(UserAndEnterprise record);

    int updateByPrimaryKey(UserAndEnterprise record);
}