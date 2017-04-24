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
	public void saveEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		enterpriseDao.insert(enterprise);
	}

	@Override
	public void updateEnterpriseCertigier(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public Enterprise getByLicenseNumber(long licenseNumber) {
		// TODO Auto-generated method stub
		return enterpriseDao.selectByLicenseNumber(licenseNumber);
	}

	@Override
	public Enterprise getByName(String name) {
		// TODO Auto-generated method stub
		return enterpriseDao.selectByEnterpriseName(name);
	}

	@Override
	public Enterprise getByLoginName(String name) {
		// TODO Auto-generated method stub
		return enterpriseDao.selectByEnterpriseLoginName(name);
	}


}
