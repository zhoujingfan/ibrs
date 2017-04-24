package com.buptsse.ibrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.InvoiceDao;
import com.buptsse.ibrs.dao.InvoiceExpenseDao;
import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.Invoice;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.UserInfo;

@Service
public class InvoiceServiceImpl implements com.buptsse.ibrs.service.InvoiceService {

	@Autowired
	InvoiceDao invoiceDao;
	@Autowired
	InvoiceExpenseDao invoiceUploadDao;
	@Override
	public void addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub

	}
	public void addUploadInvoice(InvoiceExpense invoiceUpload) {
		// TODO Auto-generated method stub
		invoiceDao.insert(invoiceUpload.getInvoice());
		invoiceUploadDao.insert(invoiceUpload);
	}
	public List<InvoiceExpense> getAllByUserInfo(long id) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectAllByUserInfoId(id);
	}
	@Override
	public List<InvoiceExpense> getAllByEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectAllByEnterprise(enterprise);
	}

}
