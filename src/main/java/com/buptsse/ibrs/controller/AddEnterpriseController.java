package com.buptsse.ibrs.controller;

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
	
	@RequestMapping(value={"/add_enterprise"})
	private String Add_Enterprise(){
		
		
		return "user/enterprise/enterprise";
	}
	@RequestMapping(value={"/add_success"})
	private String AddEnterprise(String enterpriseName,HttpSession session){
		Enterprise enterprise = enterpriseService.getByEnterpriseName(enterpriseName);
		String username = (String) session.getAttribute("username");
		UserInfo userInfo = userService.getUserInfoByUsername(username);
		relateService.UserAddEnterprise(userInfo, enterprise);
		return "user/enterprise/add_success";
	}
	
	/**
	 * 查看我已经关联的企业
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"my_enterprise"})
	private ModelAndView My_Enterprise(HttpSession session){
		String username = (String) session.getAttribute("username");
		UserInfo userInfo = userService.getUserInfoByUsername(username);
		List<Enterprise> myEnterprise = relateService.UserGetEnterprise(userInfo.getId());
		Map<Integer, Date> map = new  HashMap<Integer, Date>();
		Enterprise enterprise = new Enterprise();
		Date date = new Date();
		for(int i=0;i<myEnterprise.size();i++){
			enterprise = myEnterprise.get(i);
			date = relateService.getRelateByEnterpriseId(enterprise.getId()).getDate();
			map.put(enterprise.getId(),date);
			
		}
		int myEnterpriseNum = myEnterprise.size();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("map", map);
		modelAndView.addObject("myEnterprise", myEnterprise);
		modelAndView.addObject("myEnterpriseNum", myEnterpriseNum);
		modelAndView.setViewName("user/enterprise/myenterprise");
		System.out.println(" " + map.get(myEnterprise.get(0).getId()));
		return modelAndView;
	}
	
}
