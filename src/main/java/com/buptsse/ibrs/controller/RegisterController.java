package com.buptsse.ibrs.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.service.UserService;

@Controller
public class RegisterController {
	
	
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

}
