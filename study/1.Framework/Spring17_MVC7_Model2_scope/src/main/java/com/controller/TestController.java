package com.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

@Controller
public class TestController implements ServletContextAware{
	
	// 3개의 scope에 모델 저장
	ServletContext application;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.application = servletContext;
		
	}

	@RequestMapping("/xxx")
	public String xxx(Model m, HttpSession session) {
		
		// request scope(model 이용)
		m.addAttribute("request", "request");

		// session scope(HttpSession 이용)
		session.setAttribute("session", "session");
		
		// application scope
		application.setAttribute("application", "application");
		
		return "hello";
	}


	
}
