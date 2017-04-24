package com.buptsse.ibrs.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.Invoice;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.InvoiceService;
import com.buptsse.ibrs.service.UserAndEnterpriseService;
import com.buptsse.ibrs.service.UserService;

@Controller
public class AddInvoiceController {
	@Autowired
	UserAndEnterpriseService followService;
	@Autowired
	UserService userService;
	@Autowired
	EnterpriseService enterpriseService;
	@Autowired
	InvoiceService invoiceService;
	/**
	 * 跳转到查看我的发票界面
	 * @param session
	 * @return
	 */
	@RequestMapping(value={"myInvoice"})
	private ModelAndView MyInvoice(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<UserAndEnterprise> myEnterprise = followService.UserGetMyEnterprise(user.getUserInfo().getId());
		UserInfo userInfo = userService.getByPhoneNumber(user.getPhoneNumber()).getUserInfo();
		List<InvoiceExpense> invoiceExpense = invoiceService.getAllByUserInfo(userInfo.getId());
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("invoiceExpense",invoiceExpense);
		modelAndView.addObject("myEnterprise",myEnterprise);
		modelAndView.setViewName("user/invoice/myinvoice");
		return modelAndView;
	}
	/**
	 * 添加成功
	 * @param enterprise
	 * @param invoiceId
	 * @param invoiceNumber
	 * @param invoicePassword
	 * @param invoiceEnterprise
	 * @param taxNumber
	 * @param invoicePayee
	 * @param invoiceDate
	 * @param invoicePayer
	 * @param invoiceDetails
	 * @param invoiceSum
	 * @param session
	 * @return
	 */
	@RequestMapping(value={"add_submit"})
	private String AddSubmit(
			String enterprise,
			long invoiceId,
			long invoiceNumber,
			String invoicePassword,
			String invoiceEnterprise,
			long taxNumber,
			String invoicePayee,
			String invoiceDate,
			String invoicePayer,
			String invoiceDetails,
			Integer invoiceSum,
			HttpSession session){
		InvoiceExpense invoiceUpload = new InvoiceExpense();
		Enterprise enterP = enterpriseService.getByName(enterprise);
		User user = (User) session.getAttribute("user");
		UserInfo userInfo = user.getUserInfo();
		Invoice invoice = new Invoice();
		invoice.setInvoiceId(invoiceId);
		invoice.setNumber(invoiceNumber);
		invoice.setPassword(invoicePassword);
		invoice.setPayEnterprise(invoiceEnterprise);
		invoice.setTaxNumber(taxNumber);
		invoice.setPayee(invoicePayee);
		invoice.setPayer(invoicePayer);
		invoice.setDetails(invoiceDetails);
		invoice.setPaySum(invoiceSum);
		invoice.setPayData(invoiceDate);
		invoiceUpload.setUploadEnterprise(enterP);
		invoiceUpload.setUploadUser(userInfo);
		invoiceUpload.setInvoice(invoice);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		invoiceUpload.setUploadTime(time);
		invoiceService.addUploadInvoice(invoiceUpload);
		return "user/invoice/add_success";
	}
	@RequestMapping(value={"add_invoice"})
	private ModelAndView AddInvoice(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<UserAndEnterprise> myEnterprise = followService.UserGetMyEnterprise(user.getUserInfo().getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myEnterprise",myEnterprise);
		modelAndView.setViewName("user/invoice/addinvoice");
		return modelAndView;
	}
}
