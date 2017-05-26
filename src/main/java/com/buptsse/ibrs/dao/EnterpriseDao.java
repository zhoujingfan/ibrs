package com.buptsse.ibrs.dao;

import java.util.List;

import com.buptsse.ibrs.model.Enterprise;

public interface EnterpriseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer id);
    
    Enterprise selectByEnterpriseName(String name);
    
    Enterprise selectByEnterpriseLoginName(String name);
    
    Enterprise selectByLicenseNumber(long licenseNumber);
    
    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
    
    List<Enterprise> selectEnterpriseByUserId(Integer userId);
    
    List<Enterprise> searchEnterpriseByName(String name);
}