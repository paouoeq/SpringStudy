package com.exam.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.LoginDTO;

@Controller
public class TestController {
	
	/*
	   기존 SpringFramework의  application scope 사용
	   1) implements ServletContextAware
	   2) @Override
		  public void setServletContext(ServletContext servletContext) {
		  	  this.application = servletContext;
		  }
	 */
	
	// Boot에서는 Autowired해주면 됨
	@Autowired
	ServletContext application;
	
	@GetMapping("/main")
	public String main() {
		return "main"; // thymeleaf 설정으로 인해 src/main/resources/templates/main.html을 찾음
	}
	
	// 모델 저장 -> html에 보여줌
	@GetMapping("/main2")
	public String main2(Model m, HttpSession session) {
		// 다른 스코프, 같은 키값
		m.addAttribute("username", "홍길동1"); // request scope
		session.setAttribute("username", "홍길동2"); // session scope
		application.setAttribute("username", "홍길동3"); // application
		return "main2";
	}
	
	// 모델에 DTO 저장
	@GetMapping("/main3")
	public String main3(Model m) {
		m.addAttribute("login", new LoginDTO("aaa","1234"));
		return "main3";
	}
	
	@GetMapping("/main4")
	public String main4(Model m) {
		m.addAttribute("login", new LoginDTO("aaa","1234"));
		m.addAttribute("login2", new LoginDTO(null,"1234"));
		
		List<LoginDTO> list =
				Arrays.asList(new LoginDTO("aaa1", "1234"),
						new LoginDTO("aaa2", "345"),
						new LoginDTO("aaa3", "5422"));
		m.addAttribute("loginList", list);
		return "main4";
	}
	
	@GetMapping("/main5")
	public String main5(Model m) {
		m.addAttribute("login", new LoginDTO("aaa","1234"));
		return "main5";
	}
	
	@GetMapping("/main5_1")
	public String main5_1(@RequestParam("id") String id, @RequestParam("age") String age) {
		return "main5";
	}
	
	@GetMapping("/main6")
	public String main6() {
		return "main6";
	}
	
	
}
