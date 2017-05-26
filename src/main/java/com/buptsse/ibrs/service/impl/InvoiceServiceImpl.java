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

	public void addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub

	}

	public void addUploadInvoice(InvoiceExpense invoiceUpload) {
		// TODO Auto-generated method stub
		if (!invoiceDao.selectIfExistById(invoiceUpload.getInvoice().getInvoiceId())) {
			invoiceDao.insert(invoiceUpload.getInvoice());
		}
		if (!invoiceUploadDao.ifInvoiceExpenseExist(invoiceUpload)) {
			invoiceUploadDao.insert(invoiceUpload);
		}
	}

	public List<InvoiceExpense> getAllByUserInfo(long id) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectAllByUserInfoId(id);
	}

	public List<InvoiceExpense> getAllByEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectAllByEnterprise(enterprise);
	}

	@Override
	public int getExpenseNum(Integer userId) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectExpenseNum(userId);
	}

	@Override
	public int getExpenseSum(Integer userId) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectExpenseSum(userId);
	}

	@Override
	public int getNotExpensedByEnterprise(Integer id) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectSumNotExpenseByEnterprise(id);
	}

	@Override
	public InvoiceExpense getById(long id) {
		// TODO Auto-generated method stub
		return invoiceUploadDao.selectByPrimaryKey(id);
	}
	


}
