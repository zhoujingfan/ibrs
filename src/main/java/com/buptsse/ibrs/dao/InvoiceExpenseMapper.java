package com.buptsse.ibrs.dao;

import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.InvoiceExpenseKey;

public interface InvoiceExpenseMapper {
    int deleteByPrimaryKey(InvoiceExpenseKey key);

    int insert(InvoiceExpense record);

    int insertSelective(InvoiceExpense record);

    InvoiceExpense selectByPrimaryKey(InvoiceExpenseKey key);

    int updateByPrimaryKeySelective(InvoiceExpense record);

    int updateByPrimaryKey(InvoiceExpense record);
}