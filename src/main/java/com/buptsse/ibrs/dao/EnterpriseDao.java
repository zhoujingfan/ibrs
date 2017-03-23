package com.buptsse.ibrs.dao;

import com.buptsse.ibrs.model.Enterprise;

public interface EnterpriseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer id);

    Enterprise selectByEnterpriseNumbwe(String number);
    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}