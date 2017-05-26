package com.buptsse.ibrs.service.impl;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.EnterpriseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.EnterpriseDao;
import com.buptsse.ibrs.dao.InvoiceExpenseDao;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	
	@Autowired
	EnterpriseDao enterpriseDao;
	@Autowired
	InvoiceExpenseDao invoiceExpenseDao;

	public void saveEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		enterpriseDao.insert(enterprise);
	}

	public void updateEnterpriseCertigier(User user) {
		// TODO Auto-generated method stub

	}

	public Enterprise getByLicenseNumber(long licenseNumber) {
		// TODO Auto-generated method stub
		return enterpriseDao.selectByLicenseNumber(licenseNumber);
	}

	public Enterprise getByName(String name) {
		// TODO Auto-generated method stub
		return enterpriseDao.selectByEnterpriseName(name);
	}

	public Enterprise getByLoginName(String name) {
		// TODO Auto-generated method stub
		return enterpriseDao.selectByEnterpriseLoginName(name);
	}
	
	public List<InvoiceExpense> getNotExpenseInvoices(Enterprise enterprise){
		return invoiceExpenseDao.selectNotExpenseByEnterprise(enterprise);
	}

	@Override
	public void UpdateMessage(List<InvoiceExpense> invoices) {
		// TODO Auto-generated method stub
		for(int i=0;i<invoices.size();i++){
			invoiceExpenseDao.updateMessage(invoices.get(i));
		}
		
	}

	@Override
	public List<InvoiceExpense> getExpenseInvoices(Enterprise enterprise) {
		// TODO Auto-generated method stub
		
		return invoiceExpenseDao.selectExpenseByEnterprise(enterprise);
	}

	@Override
	public void NotPass(InvoiceExpense invoice) {
		// TODO Auto-generated method stub
		invoiceExpenseDao.updateMessageNotPass(invoice);
	}

	@Override
	public List<Enterprise> searchEnterprise(String name) {
		// TODO Auto-generated method stub
		return enterpriseDao.searchEnterpriseByName(name);
	}


}
