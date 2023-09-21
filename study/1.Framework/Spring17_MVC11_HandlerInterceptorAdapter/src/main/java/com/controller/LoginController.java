package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dto.LoginDTO;

@Controller
public class LoginController {
	
	@GetMapping("/loginForm")
	public String home() {
		
		return "loginForm"; // /WEB-INF/view/loginForm.jsp로 포워드 요청된다.
	}
	
	@GetMapping("/login")
	public String login(LoginDTO dto, HttpSession session) {
		
		// 1. 저장된 데이터 이용해서 DB 연동 및 검증 (했다고 가정)
		// 2. 세션에 저장
		session.setAttribute("login", dto);
		return "login";
	}
	
	@GetMapping("/loginCheck/logout")
	public String logout(HttpSession session) {
		
//		// 1. 로그인 체크 여부 확인 - 세션에 키값이 있는지 확인
//		LoginDTO dto = (LoginDTO)session.getAttribute("login");
//		if(dto==null) { // 세션에 키값이 없으면
//			return "redirect:loginForm"; // 로그인 하도록
//		}
//		else { // 키값이 존재하면
			session.invalidate(); // 로그아웃 시킴(세션값 삭제)
			return "main";
//		}
		
	}
	
	@GetMapping("/loginCheck/mypage")
	public String mypage(HttpSession session) {
		// 로그인 이후의 작업 => 로그인 체크 여부 확인 필요
		
		session.invalidate(); // 로그아웃 시킴(세션값 삭제)
		return "main";
	}
}
