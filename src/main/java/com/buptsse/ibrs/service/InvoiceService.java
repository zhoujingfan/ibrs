package com.buptsse.ibrs.service;

import java.util.List;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.Invoice;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.UserInfo;

public interface InvoiceService {
	
	void addInvoice(Invoice invoice);
	
	void addUploadInvoice(InvoiceExpense invoiceUpload);

	InvoiceExpense getById(long id);
	
	List<InvoiceExpense> getAllByUserInfo(long id);
	
	List<InvoiceExpense> getAllByEnterprise(Enterprise enterprise);
	
	int getExpenseNum(Integer userId);
	
	int getExpenseSum(Integer userId);
	
	int getNotExpensedByEnterprise(Integer id);
}
