package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // controller 클래스 지정과 동시에 마킹도 한 것
public class TestController {
	
	// 요청url : http:localhost8090/app/xxx
	@RequestMapping("/xxx")
	public String home() {
		System.out.println("TestController.home 메서드");
		
		// 명시적으로 예외 발생
		if(true) throw new ArithmeticException("error 발생");
		
		return "hello";
	}
	
	// 요청url : http:localhost8090/app/yyy
	@RequestMapping("/yyy")
	public String main() {
		System.out.println("TestController.main 메서드");
		
		// 명시적으로 예외 발생
		if(true) throw new NullPointerException("error 발생");
		
		return "hello";
	}
	
	@ExceptionHandler({ArithmeticException.class, NullPointerException.class}) // 해당 예외를 처리해주는 예외 페이지가 됨
	public String errorPage() {
		return "error"; // /WEB-INF/view/error.jsp
	}
}
