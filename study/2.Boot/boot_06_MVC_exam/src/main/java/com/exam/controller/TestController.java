package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 7. Controller 생성
@Controller
public class TestController {
	
	// 8. 메서드 생성
	@GetMapping("/main")
	public String main() {
		System.out.println("TestController.main");
		return "hello";
	}
}
