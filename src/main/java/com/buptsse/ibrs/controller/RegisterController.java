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
	/**
	 * 重定向到个人用户注册界面
	 * @return
	 */
	@RequestMapping(value={"to_register"})
	private String ToRegister(){
		return "register/user_register";
	}
	
	/**
	 * 个人用户注册
	 * @param phoneNumber
	 * @param regi_password
	 * @param session
	 * @return
	 */
	@RequestMapping("register")
	private String Register(long phoneNumber, String regi_password, HttpSession session){
		User user = userService.getByPhoneNumber(phoneNumber);
		if(user != null){
			System.out.println("用户已经存在");
		}
		else{
			user  = new User();
			user.setPhoneNumber(phoneNumber);
			user.setPassword(regi_password);
			userService.AddUser(user);
			session.setAttribute("user", user);
			System.out.println("注册成功");
			return "register/identification";
		}
		return "/login/login";
	}
	/**
	 * 实名认证
	 * @param truename
	 * @param idNumber
	 * @param address
	 * @param birthday
	 * @param session
	 * @return
	 */
	@RequestMapping(value={"identification"})
	private String Identification(
			String truename,
			String idNumber,
			String address,
			String birthday,
			HttpSession session
			){

		User user = (User) session.getAttribute("user");
		user = userService.getByPhoneNumber(user.getPhoneNumber());
		UserInfo userInfo = new UserInfo();
		userInfo.setTruename(truename);
		userInfo.setIdNumber(idNumber);
		userInfo.setAddress(address);
		userInfo.setBirthday(birthday);
		userInfo.setPhoneNumber(user.getPhoneNumber());
		user.setUserInfo(userInfo);
		userService.saveIdentification(user);
		return "login/login";
	}
	
	/**
	 * 跳转到企业注册
	 * @return
	 */
	@RequestMapping(value={"enterprise"})
	private String Enterprise(){
		return "register/enterprise_register";
	}
	/**
	 * 企业注册
	 * @param enterprise_name
	 * @param login_name
	 * @param password
	 * @param enterprise_address
	 * @param license_number
	 * @param certigier_name
	 * @param certigier_id_number
	 * @param certigier_phone_number
	 * @param certigier_email
	 * @param certigier_address
	 * @return
	 */
	@RequestMapping(value={"enterprise_register"})
	private String EnterpriseRegister(String enterprise_name,
			String login_name,
			String password,
			String enterprise_address,
			long license_number,
			String certigier_name,
			String certigier_id_number,
			long certigier_phone_number,
			String certigier_email,
			String certigier_address
			){
		UserInfo user = userService.getByIdnumber(certigier_id_number);
		Enterprise enterprise = enterpriseService.getByLicenseNumber(license_number);
		if(enterprise != null){
			System.out.println("该企业已经注册");		
			
		}
		else{
			if(user == null){
				user = new UserInfo();
				user.setAddress(certigier_address);
				user.setTruename(certigier_name);
				user.setIdNumber(certigier_id_number);
				user.setPhoneNumber(certigier_phone_number);
				userService.SaveUserInfo(user);
				user = userService.getByIdnumber(certigier_id_number);
			}
			enterprise = new Enterprise();
			enterprise.setAddress(enterprise_address);
			enterprise.setLicenseNumber(license_number);
			enterprise.setPassword(password);
			enterprise.setLoginName(login_name);
			enterprise.setName(enterprise_name);
			enterprise.setCertigier(user);
			enterpriseService.saveEnterprise(enterprise);
		}
		
		return "index";
	}
}
