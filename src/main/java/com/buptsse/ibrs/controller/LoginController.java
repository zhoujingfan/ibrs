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
	private void Login(){
		System.out.println("hello world11");
	}
	
	/**
	 * 个人用户登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/main")
	private String LoginSubmit(String username, String password, HttpSession session){
		User user = userService.getByUsername(username);
		
		if(user.getPassword().equals(password)){
			session.setAttribute("username", username);
			session.setAttribute("user", user);
			return "main";
		}else
			return "login";
	}

}
