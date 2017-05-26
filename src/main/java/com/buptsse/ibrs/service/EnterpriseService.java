package com.buptsse.ibrs.service;

import java.util.List;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.User;

public interface EnterpriseService {
	
	void saveEnterprise(Enterprise enterprise);
	void updateEnterpriseCertigier(User user);
	public List<InvoiceExpense> getNotExpenseInvoices(Enterprise enterprise);
	public List<InvoiceExpense> getExpenseInvoices(Enterprise enterprise);
	Enterprise getByName(String name);
	Enterprise getByLoginName(String name);
	Enterprise getByLicenseNumber(long licneseNumber);
	void UpdateMessage(List<InvoiceExpense> invoices);
	void NotPass(InvoiceExpense invoice);
	List<Enterprise> searchEnterprise(String name);
}
