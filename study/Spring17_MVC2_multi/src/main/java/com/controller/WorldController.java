package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorldController {
	
	// 요청url : http://localhost:8090/app/yyy
	@RequestMapping(value = "/yyy")
	public String aaa() {
		System.out.println("WorldController.aaa");
		
		// forward 방식
		return "/WEB-INF/views/aaa.jsp";
	}
}
