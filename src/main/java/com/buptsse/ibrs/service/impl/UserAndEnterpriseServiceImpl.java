package com.buptsse.ibrs.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.EnterpriseDao;
import com.buptsse.ibrs.dao.UserAndEnterpriseDao;
import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.UserAndEnterpriseService;

@Service
public class UserAndEnterpriseServiceImpl implements UserAndEnterpriseService {

	@Autowired
	UserAndEnterpriseDao relateDao;

	@Autowired
	EnterpriseDao enterpriseDao;

	@Override
	public String UserAddEnterprise(UserInfo user, Enterprise enterprise) {
		// TODO Auto-generated method stub
		List<UserAndEnterprise> myFollow = relateDao.getMyEnterprise(user.getId());
		boolean ifExist = false;
		for(int i = 0;i<myFollow.size();i++){
			if(myFollow.get(i).getEnterpriseId().getId() == enterprise.getId())
				ifExist = true;
		}
		if (ifExist) {
			System.out.println("已经关联该企业");
			return "exist";
		} else {
			UserAndEnterprise follow = new UserAndEnterprise();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			follow.setAddTime(time);
			follow.setUserId(user);
			follow.setEnterpriseId(enterprise);
			relateDao.insert(follow);
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

	@Override
	public List<UserAndEnterprise> EnterpriseGetEmployee(Integer enterpriseId) {
		// TODO Auto-generated method stub
		return relateDao.getMyEmployee(enterpriseId);
	}

}
