package com.buptsse.ibrs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.UserAndEnterpriseService;
import com.buptsse.ibrs.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserAndEnterpriseService followService;
	@Autowired
	EnterpriseService enterpriseService;
	
	@RequestMapping(value={"myprofile_submit"})
	private String myProfileSubmit(HttpSession session,
			long phoneNumber,
			String email,
			String address
			){
		User user = (User) session.getAttribute("user");
		user.getUserInfo().setPhoneNumber(phoneNumber);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.getUserInfo().setAddress(address);
		session.removeAttribute("user");
		session.setAttribute("user", user);
		userService.updateUser(user);
		return "user/add_success";
		
	}
	
	@RequestMapping(value={"manageEnterprise"})
	private String ManageEnterprise(HttpSession session, String name){
		System.out.println();
		return null;
	}
	@RequestMapping(value={"deleteEnterprise"})
	
	private String DeleteEnterprise(HttpSession session, String name){
		UserAndEnterprise record = new UserAndEnterprise();
		User user = (User) session.getAttribute("user");
		Enterprise enterprise = enterpriseService.getByName(name);
		record.setUserId(user.getUserInfo());
		record.setEnterpriseId(enterprise);
		record = followService.getFollow(record);
		followService.deleteFollow(record.getFollowId());
		return "user/enterprise/delete_success";
	}
	
	@RequestMapping(value={"tixian"})
	private String TiXian(HttpSession session){
		
		return "user/tixian";
	}
	@RequestMapping(value={"tixian_success"})
	private String TiXianchenggongle(HttpSession session, int money){
		User user = (User) session.getAttribute("user");
		int mm = user.getUserInfo().getMoney();
		mm = mm + money;
		user.getUserInfo().setMoney(mm);
		userService.updateMoney(user);
		return "user/tixian_success";
	}
}
