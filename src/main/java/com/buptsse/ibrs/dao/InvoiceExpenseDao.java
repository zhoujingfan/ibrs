package com.buptsse.ibrs.dao;

import java.util.List;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.InvoiceExpenseKey;

public interface InvoiceExpenseDao {
    int deleteByPrimaryKey(InvoiceExpenseKey key);

    int insert(InvoiceExpense record);

    int insertSelective(InvoiceExpense record);

    InvoiceExpense selectByPrimaryKey(long key);
    
    boolean ifInvoiceExpenseExist(InvoiceExpense invoiceExpense);

    List<InvoiceExpense> selectAllByUserInfoId(long id);
    
    List<InvoiceExpense> selectAllByEnterprise(Enterprise enterprise);
    
    List<InvoiceExpense> selectNotExpenseByEnterprise(Enterprise enterprise);
    
    List<InvoiceExpense> selectExpenseByEnterprise(Enterprise enterprise);
     
    int updateByPrimaryKeySelective(InvoiceExpense record);

    int updateByPrimaryKey(InvoiceExpense record);
    
    int updateMessage(InvoiceExpense record);
    
    int updateMessageNotPass(InvoiceExpense record);
    
    int selectExpenseNum(Integer userInfoId);
    
    int selectExpenseSum(Integer userInfoId);
    
    int selectSumNotExpenseByEnterprise(Integer id);

}