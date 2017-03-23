package com.buptsse.ibrs.service.impl;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.EnterpriseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.EnterpriseDao;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	
	@Autowired
	EnterpriseDao enterpriseDao;
	
	@Override
	public Enterprise getEnterpriseByNumber(String number) {
		// TODO Auto-generated method stub
		
		return enterpriseDao.selectByEnterpriseNumbwe(number);
	}

	@Override
	public void saveEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		enterpriseDao.insert(enterprise);
	}

	@Override
	public void updateEnterpriseCertigier(User user) {
		// TODO Auto-generated method stub

	}

}
