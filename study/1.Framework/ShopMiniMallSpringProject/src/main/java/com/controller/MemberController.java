package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service; // MemberService service = new MemberServiceImpl();
	
	@GetMapping("/MemberUIServlet")
	public String MemberUI() { // MemberUIServlet 역할
		return "memberForm";
	}
	
	@PostMapping("/MemberAddServlet")
	public String MemberAdd(MemberDTO dto) { // 여기까지가 MemberAddServlet의 31번라인까지의 역할
		int n = service.memberAdd(dto);
		
		return"redirect:LoginUIServlet"; // response.sendRedirect("LoginUIServlet");
	}
	
	@GetMapping("/MyPageServlet")
	public String mypage(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		// 로그인 여부 확인은 Interceptor 이용한다. => if절 안에 있는 내용만 구현하면 됨
		String userid = dto.getUserid();
		MemberDTO mypage = service.mypage(userid);
		session.setAttribute("login", mypage);
		
		return "mypage"; // /WEB-INF/views/mypage.jsp
	}
	
	
	/* 1. ajax 연동
	   2. 응답을 jsp가 아닌 일반 데이터(문자열, JSON 형태)
	   3. 의존성 주입 필요(pom.xml)
	   <dependency>
	     <groupId>com.fasterxml.jackson.core</groupId>
	     <artifactId>jackson-databind</artifactId>
	     <version>2.14.2</version>
	   </dependency> */
	
	@GetMapping(value="/MemberIdCheckServlet", produces = "text/plain;charset=utf-8")
	@ResponseBody // @ResponseBody에 의해 리턴값인 문자열이 뷰정보가 아닌 문자열로 처리된다.
	public String idCheck(@RequestParam("userid") String userid) {
		MemberDTO dto = service.idCheck(userid);
		
		String mesg = "아이디 사용 가능";
		if(dto != null) { // null이 아님 => dto 존재 => 동일한 아이디 있음
			mesg = "아이디 중복";
		}
		
		return mesg;
	}
}
