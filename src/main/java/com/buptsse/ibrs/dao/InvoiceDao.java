package com.buptsse.ibrs.dao;

import com.buptsse.ibrs.model.Invoice;

public interface InvoiceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(long id);
    
    boolean selectIfExistById(long id);
    
    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
    
}