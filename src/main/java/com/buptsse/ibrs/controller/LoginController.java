package com.buptsse.ibrs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login" )
	private String  Login(){
		System.out.println("hello world11");
		return "login";
	}

	@RequestMapping("/enterprise_login" )
	private String  EnterpriseLogin(){
		System.out.println("hello world11");
		return "login";
	}
	/**
	 * 个人用户登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value={"login/main"})
	private String LoginSubmit(String username, String password, HttpSession session){
		User user = userService.getByUsername(username);
		if(user == null){
			return "login";
		}
		
		else if(user.getPassword().equals(password)){
			session.setAttribute("username", username);
			session.setAttribute("user", user);
			return "redirect:../main";
		}else
			return "redirect:login";
	}
	
	@RequestMapping(value={"main"})
	private String RequestMain(){
		return "user/main";
	}
	
}
