package com.buptsse.ibrs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.UserAndEnterpriseService;
import com.buptsse.ibrs.service.UserService;
@Controller
public class AddEnterpriseController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserAndEnterpriseService relateService;
	@Autowired
	EnterpriseService enterpriseService;
	/**
	 * 个人用户添加企业关联页面
	 * @return
	 */
	@RequestMapping(value={"/add_enterprise"})
	private String Add_Enterprise(){
		
		
		return "user/enterprise/enterprise";
	}
	/**
	 * 添加成功页面
	 * @param enterpriseName
	 * @param session
	 * @return
	 */
	@RequestMapping(value={"/add_success"})
	private String AddEnterprise(String enterpriseName,HttpSession session){
		Enterprise enterprise = enterpriseService.getByName(enterpriseName);
		User user = (User) session.getAttribute("user");
		UserInfo userInfo = user.getUserInfo();
		relateService.UserAddEnterprise(userInfo, enterprise);
		return "user/enterprise/add_success";
	}
	
	/**
	 * 查看我已经关联的企业
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value={"search"})
	private ModelAndView SearchEnterprise(HttpSession session, String enterpriseName){
		List<Enterprise> enterprises = enterpriseService.searchEnterprise("%"+enterpriseName+"%");
		ModelAndView model = new ModelAndView();
		model.addObject("enterprises", enterprises);
		model.setViewName("user/enterprise/search");
		return model;
	}
	@RequestMapping(value = {"my_enterprise"})
	private ModelAndView My_Enterprise(HttpSession session){
		User loginUser = (User) session.getAttribute("user");
		List<UserAndEnterprise> myEnterprise = relateService.UserGetMyEnterprise(loginUser.getUserInfo().getId());
		int myEnterpriseNum = myEnterprise.size();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myEnterprise", myEnterprise);
		modelAndView.addObject("myEnterpriseNum", myEnterpriseNum);
		modelAndView.setViewName("user/enterprise/myenterprise");
		return modelAndView;
	}
	
}
