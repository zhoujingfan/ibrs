package com.buptsse.ibrs.service;

import java.util.List;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;

public interface UserAndEnterpriseService {

	String UserAddEnterprise(UserInfo user, Enterprise enterprise);
	List<UserAndEnterprise> UserGetMyEnterprise(Integer userId);
	List<UserAndEnterprise> EnterpriseGetEmployee(Integer enterpriseId);
	List<Enterprise> UserGetEnterprise(Integer userId);
	UserAndEnterprise getRelateByEnterpriseId(Integer id);
	String EnterpriseAddUser(UserInfo user);
	String EnterpriseAddUser(List<UserInfo> users);
}
