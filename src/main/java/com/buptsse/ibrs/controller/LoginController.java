package com.buptsse.ibrs.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private EnterpriseService enterpriseService;
	@RequestMapping("/login" )
	private String  Login(){
		return "login";
	}

	/**
	 * 企业登录界面跳转
	 * @return
	 */
	@RequestMapping("/enterprise_login" )
	private String  EnterpriseLogin(){
		return "login/enterprise_login";
	}
	/**
	 * 个人用户登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value={"login/main"})
	private String LoginSubmit(long phoneNumber, String password, HttpSession session){
		User user = userService.getByPhoneNumber(phoneNumber);
		if(user == null){
			return "redirect:../login";
		}
		
		else if(user.getPassword().equals(password)){
			if(user.getUserInfo().getId() == null){
				System.out.println("请完成实名认证");
			}else{
				session.setAttribute("username", user.getUserInfo().getTruename());
			}
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			session.setAttribute("user", user);
			user.setLastLoginTime(time);
			userService.updateLoginTime(user);
			return "redirect:../main";
		}else
			return "login";
	}
	/**
	 * 跳转主页
	 * @return
	 */
	@RequestMapping(value={"main"})
	private String RequestMain(){
		return "user/main";
	}
	
	/**
	 * 企业登录，跳转到的企业主页
	 * @param name
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value={"enterprise_main"})
	private String EnterpriseSubmit(String name, String password, HttpSession session){
		Enterprise enterprise = enterpriseService.getByLoginName(name);
		if(enterprise.getPassword().equals(password)){
			session.setAttribute("enterprise", enterprise);
			return "enterprise/main";
		}
		return null;
	}
	
}
