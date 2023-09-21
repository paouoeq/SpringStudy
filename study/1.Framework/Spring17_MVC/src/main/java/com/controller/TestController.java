package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // controller 클래스 지정과 동시에 마킹도 한 것
public class TestController {
	
	// 요청url : http:localhost8090/app/xxx
	@RequestMapping("/xxx")
	public String home() {
		System.out.println("TestController.home 메서드");
		return "/WEB-INF/views/hello.jsp";
	}
	
	// 요청url : http:localhost8090/app/yyy
	@RequestMapping("/yyy")
	public String main() {
		System.out.println("TestController.main 메서드");
		return "/WEB-INF/views/hello.jsp";
	}
}
