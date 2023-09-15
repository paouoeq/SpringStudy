package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	// 요청url : http://localhost:8090/app/xxx
	@RequestMapping("/xxx")
	public String aaa() {
		System.out.println("HelloController.aaa");
		
		// forward 방식
		return "/WEB-INF/views/aaa.jsp";
	}
}
