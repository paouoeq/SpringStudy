package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// context:component-scan으로 등록함
@Controller
public class TestController {
	
	// 1. 맵핑값 하나
	@RequestMapping(value="/xxx")
	public String xxx() {
		System.out.println("TestController.xxx");
		return "/WEB-INF/views/main.jsp";
	}
	
	// 2. 맵핑값 두개
	@RequestMapping(value={"/xxx2", "/xxx3"})
	public String xxx2_3() {
		System.out.println("TestController.xxx2_3");
		return "/WEB-INF/views/main.jsp";
	}
	
	// 3. 특정값으로 시작
	@RequestMapping(value="/yyy*")
	public String yyy() {
		System.out.println("TestController.yyy");
		return "/WEB-INF/views/main.jsp";
	}
	
	// 4. 특정경로 하나
	@RequestMapping(value="/zzz/*")
	public String zzz() {
		System.out.println("TestController.zzz");
		return "/WEB-INF/views/main.jsp";
	}
	
	// 5. 특정경로 여러개
	@RequestMapping(value="/kkk/**")
	public String kkk() {
		System.out.println("TestController.kkk");
		return "/WEB-INF/views/main.jsp";
	}
	
	// 6. 경로 중간에 패턴 지정
	@RequestMapping(value="/eee/**/fff")
	public String eee() {
		System.out.println("TestController.eee");
		return "/WEB-INF/views/main.jsp";
	}
	
}
