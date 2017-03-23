package com.buptsse.ibrs.service;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.User;

public interface EnterpriseService {
	
	Enterprise getEnterpriseByNumber(String number);
	void saveEnterprise(Enterprise enterprise);
	void updateEnterpriseCertigier(User user);

}
