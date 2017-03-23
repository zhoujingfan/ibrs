package com.buptsse.ibrs.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	EnterpriseService enterpriseService;
	
	@Autowired
	UserService userService;
	@RequestMapping("/register")
	private String Register(String regi_name, String regi_password, HttpSession session){
		User user = userService.getByUsername(regi_name);
		if(user != null){
			System.out.println("用户已经存在");
		}
		else{
			user  = new User();
			user.setUsername(regi_name);
			user.setPassword(regi_password);
			userService.AddUser(user);
			System.out.println("注册成功");
		}
		return "login";
	}

	@RequestMapping("/register_enterprise")
	private String EnterpriseRegister(String enterprise_name,
			String enterprise_number,
			String enterprise_address,
			String license_number,
			String certigier_name,
			String certigier_id_number,
			String certigier_phone_number,
			String certigier_email,
			String certigier_address
			){
		UserInfo user = userService.getByPhoneNumber(certigier_phone_number);
		Enterprise enterprise = enterpriseService.getEnterpriseByNumber(enterprise_number);
		if(enterprise != null){
			System.out.println("该企业已经注册");		
			
		}
		else{
			if(user == null){
				user = new UserInfo();
				user.setAddress(certigier_address);
				user.setTruename(certigier_name);
				user.setEmail(certigier_email);
				user.setIdcardnumber(certigier_id_number);
				user.setPhonenumber(certigier_phone_number);
				userService.SavaUserInfo(user);
				userService.getByPhoneNumber(certigier_phone_number);
			}
			enterprise = new Enterprise();
			enterprise.setEnterpriseName(enterprise_name);
			enterprise.setEnterpriseNumber(enterprise_number);
			enterprise.setEnterpriseAddress(enterprise_address);
			enterprise.setLicenseNumbwe(license_number);
			enterprise.setCertigier(user.getId());
		}
		
		return "index";
	}
}
