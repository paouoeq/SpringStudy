package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// context:component-scan으로 등록함
@Controller
public class TestController {
	
//	@RequestMapping(value = "/loginForm", method = RequestMethod.GET) // get쓰고 ctrl+space => 자동완성
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("loginForm");
		return "/WEB-INF/views/loginForm.jsp";
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST) // get쓰고 ctrl+space => 자동완성
	@PostMapping("/login")
	public String login() {
		System.out.println("loginForm");
		return "/WEB-INF/views/main.jsp";
	}
	
}
