package com.buptsse.ibrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecordController {

	@RequestMapping(value={"myRecord"})
	private String MyRecord(){
		return "user/record";
	}
}
