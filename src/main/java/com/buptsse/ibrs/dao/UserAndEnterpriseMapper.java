package com.buptsse.ibrs.dao;

import com.buptsse.ibrs.model.UserAndEnterprise;

public interface UserAndEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndEnterprise record);

    int insertSelective(UserAndEnterprise record);

    UserAndEnterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAndEnterprise record);

    int updateByPrimaryKey(UserAndEnterprise record);
}