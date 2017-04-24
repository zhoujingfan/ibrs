package com.buptsse.ibrs.dao;

import java.util.List;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.InvoiceExpenseKey;

public interface InvoiceExpenseDao {
    int deleteByPrimaryKey(InvoiceExpenseKey key);

    int insert(InvoiceExpense record);

    int insertSelective(InvoiceExpense record);

    InvoiceExpense selectByPrimaryKey(InvoiceExpenseKey key);

    List<InvoiceExpense> selectAllByUserInfoId(long id);
    
    List<InvoiceExpense> selectAllByEnterprise(Enterprise enterprise);
    
    int updateByPrimaryKeySelective(InvoiceExpense record);

    int updateByPrimaryKey(InvoiceExpense record);
}