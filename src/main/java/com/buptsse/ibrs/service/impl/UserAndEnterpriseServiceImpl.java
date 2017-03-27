package com.buptsse.ibrs.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.EnterpriseDao;
import com.buptsse.ibrs.dao.UserAndEnterpriseMapper;
import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.UserAndEnterpriseService;

@Service
public class UserAndEnterpriseServiceImpl implements UserAndEnterpriseService {

	@Autowired
	UserAndEnterpriseMapper relateDao;

	@Autowired
	EnterpriseDao enterpriseDao;

	@Override
	public String UserAddEnterprise(UserInfo user, Enterprise enterprise) {
		// TODO Auto-generated method stub
		if (relateDao.getMyEnterprise(user.getId()).size() != 0) {
			System.out.println("已经关联该企业");
			return "exist";
		} else {
			UserAndEnterprise relate = new UserAndEnterprise();
			relate.setUserid(user.getId());
			relate.setEnterprise(enterprise.getId());
			try {
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = format.format(date);
				date = format.parse(time);

				relate.setDate(date);
			} catch (ParseException e) {

			}
			relateDao.insert(relate);
			return "success";
		}
	}

	@Override
	public String EnterpriseAddUser(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String EnterpriseAddUser(List<UserInfo> users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAndEnterprise> UserGetMyEnterprise(Integer userId) {
		// TODO Auto-generated method stub

		return relateDao.getMyEnterprise(userId);
	}

	@Override
	public List<Enterprise> UserGetEnterprise(Integer userId) {
		// TODO Auto-generated method stub

		return enterpriseDao.selectEnterpriseByUserId(userId);
	}

	@Override
	public UserAndEnterprise getRelateByEnterpriseId(Integer id) {
		// TODO Auto-generated method stub
		
		return relateDao.selectByEnterpriseId(id);
	}

}
