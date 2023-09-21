package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.LoginDTO;

@Controller
public class LoginController {
	
	@GetMapping("/loginForm")
	public String home() {
		
		return "loginForm"; // /WEB-INF/view/loginForm.jsp로 포워드 요청된다.
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/login")
	public String login(@RequestParam Map<String, String> m) {
		
		// 사용자 입력 데이터 얻기
		System.out.println(m);
		return "login";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 요청 파라미터명과 저장할 변수명이 일치하면 요청 파라미터명을 생략할 수 있다.
	@GetMapping("/login5")
	public String login5(LoginDTO dto) {
		
		// 사용자 입력 데이터 얻기
		System.out.println(dto);
		return "login";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 요청 파라미터명과 저장할 변수명이 일치하면 요청 파라미터명을 생략할 수 있다.
	@GetMapping("/login4")
	public String login4(@RequestParam String userid, 
						@RequestParam("passwd") String pw) {
		
		// 사용자 입력 데이터 얻기
		System.out.println(userid+" "+pw);
		return "login";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 	@RequestParam 사용 주의할 점
	 	 - 존재하지 않는 key에 경우 null값을 반환하는 것이 아니라 에러가 발생한다.
	 	 - 따라서 반드시 존재하는 input의 name값을 넣어줘야 한다. (필수사항)
	 	   => 이를 옵션으로 바꿀 수 있다.
	 	   : @RequestParam의 required 속성을 false로 설정한다.
	 	   => null값 대신에 기본값으로 설정도 가능하다.
	 	   : @RequestParam의 defaultValue 속성값을 지정한다.
	 */
	@GetMapping("/login3")
	public String login3(@RequestParam(value="userid2", required=false, defaultValue="nothing") String id, 
						 @RequestParam("passwd") String pw) {
		
		// 사용자 입력 데이터 얻기
		System.out.println(id+" "+pw);
		return "login";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/login2")
	public String login2(@RequestParam("userid") String id, 
						 @RequestParam("passwd") String pw) {
		
		// 사용자 입력 데이터 얻기
		System.out.println(id+" "+pw);
		return "login";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/login1")
	public String login1(HttpServletRequest request) {
		
		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		System.out.println(userid+" "+passwd);
		
		return "login";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/login") // 요청맵핑값이 같아도 get/post로 구별할 수 있기 때문에 오류가 나지 않는다.
	public String login1_1(HttpServletRequest request) {
		
		// 사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		System.out.println(userid+" "+passwd);
		
		return "login";
	}
}
