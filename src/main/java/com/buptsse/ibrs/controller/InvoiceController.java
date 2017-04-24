package com.buptsse.ibrs.controller;

import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.service.InvoiceService;

@Controller
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	private ModelAndView EnterpriseGetInvocie(HttpSession session){
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		return null;
	}
}
