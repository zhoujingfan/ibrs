package com.buptsse.ibrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddInvoiceController {
	
	@RequestMapping(value={"myInvoice"})
	private String MyInvoice(){
		return "user/invoice/add";
	}
	@RequestMapping(value={"add_invoice"})
	private String AddInvoice(){
		
		return "user/invoice/add_success";
	}
}
