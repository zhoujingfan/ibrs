package com.buptsse.ibrs.service;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.User;

public interface EnterpriseService {
	
	void saveEnterprise(Enterprise enterprise);
	void updateEnterpriseCertigier(User user);

	Enterprise getByName(String name);
	Enterprise getByLoginName(String name);
	Enterprise getByLicenseNumber(long licneseNumber);
}
