package com.buptsse.ibrs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.UserAndEnterpriseService;
import com.buptsse.ibrs.service.UserService;

@Controller
public class EnterpriseController {
	@Autowired
	UserService userService;
	@Autowired
	EnterpriseService enterpriseService;
	@Autowired
	UserAndEnterpriseService followService;
	
	@RequestMapping(value={"myEmployee"})
	private ModelAndView MyEmloyee(HttpSession session){
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		List<UserAndEnterprise> follows = followService.EnterpriseGetEmployee(enterprise.getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("follows", follows);
		modelAndView.setViewName("enterprise/employee/employee");
		return modelAndView;
	}
}
