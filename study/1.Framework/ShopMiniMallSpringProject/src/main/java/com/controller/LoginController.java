package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService service;
	
	/* 화면만 보여주는 경우에는 servlet-context.xml에서 동일하게 구현할 수 있다.
	   <mvc:view-controller path="/LoginUIServlet" view-name="loginForm"/> <!-- path는 요청받을 맵핑값 / view-name은 명시적 view이름 -->
	@GetMapping("/LoginUIServlet")
	public String loginUI() {
		return "loginForm";
	}*/
	
	@GetMapping("/LoginServlet")
	public String login(@RequestParam HashMap<String, String> map, HttpSession session) { // 여기까지가 LoginServlet 26라인까지와 동일
		
		MemberDTO dto = service.login(map);
		
		String nextPage=null;
		if(dto!=null) {
			session.setAttribute("login", dto);
			nextPage = "redirect:main";
		}
		else {
			nextPage = "member/loginFail";
		}
		
		return nextPage;
	}
	
	@GetMapping("/LogoutServlet")
	public String logout(HttpSession session) {
		
		// 로그인 여부 확인은 Interceptor가 한다.
		session.invalidate(); // 로그아웃
		
		return "redirect:main";
	}
}
