package com.buptsse.ibrs.dao;

import java.util.List;

import com.buptsse.ibrs.model.Enterprise;

public interface EnterpriseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer id);

    Enterprise selectByEnterpriseNumber(String number);
    
    Enterprise selectByEnterpriseName(String name);
    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
    
    List<Enterprise> selectEnterpriseByUserId(Integer userId);
}