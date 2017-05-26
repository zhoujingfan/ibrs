package com.buptsse.ibrs.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buptsse.ibrs.dao.EnterpriseDao;
import com.buptsse.ibrs.dao.UserAndEnterpriseDao;
import com.buptsse.ibrs.dao.UserInfoDao;
import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.UserAndEnterpriseService;

@Service
public class UserAndEnterpriseServiceImpl implements UserAndEnterpriseService {

	@Autowired
	UserAndEnterpriseDao relateDao;

	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	EnterpriseDao enterpriseDao;

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
			UserInfo ifex = userInfoDao.selectByIdNumber(user.getIdNumber());
			if(ifex == null){
				userInfoDao.insert(user);
			}
			user = userInfoDao.selectByIdNumber(user.getIdNumber());
			UserAndEnterprise follow = new UserAndEnterprise();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			follow.setAddTime(time);
			follow.setUserId(user);
			follow.setEnterpriseId(enterprise);
			follow.setIfLeave("否");
			relateDao.insert(follow);
			return "success";
		}
	}

	public String EnterpriseAddUser(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String EnterpriseAddUser(List<UserInfo> users) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserAndEnterprise> UserGetMyEnterprise(Integer userId) {
		// TODO Auto-generated method stub

		return relateDao.getMyEnterprise(userId);
	}

	public List<Enterprise> UserGetEnterprise(Integer userId) {
		// TODO Auto-generated method stub

		return enterpriseDao.selectEnterpriseByUserId(userId);
	}

	public UserAndEnterprise getRelateByEnterpriseId(Integer id) {
		// TODO Auto-generated method stub
		
		return relateDao.selectByEnterpriseId(id);
	}

	public List<UserAndEnterprise> EnterpriseGetEmployee(Integer enterpriseId) {
		// TODO Auto-generated method stub
		return relateDao.getMyEmployee(enterpriseId);
	}

	@Override
	public int getMyEnterpriseSum(Integer userId) {
		// TODO Auto-generated method stub
		return relateDao.getMyEnterpriseNum(userId);
	}

	@Override
	public int deleteFollow(Integer id) {
		// TODO Auto-generated method stub
		return relateDao.deleteFollow(id);
	}

	@Override
	public UserAndEnterprise getFollow(UserAndEnterprise record) {
		//                 TODO Auto-generated method stub
		return relateDao.selectFollow(record);
	}

	@Override
	public int getMyEmployeeNum(Integer id) {
		// TODO Auto-generated method stub
		return relateDao.getMyEmployeeNum(id);
	}

}
