package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {



	@RequestMapping("/staff")
	public String index2() {
		return "staff/staffList";
	}
	@RequestMapping("/records")
	public String index3() {
		return "records/recordsList";
	}
	@RequestMapping("/departs")
	public String index4() {
		return "departs/departsList";
	}
}
