package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.LoginDTO;

@Controller // controller 클래스 지정과 동시에 마킹도 한 것
public class TestController {
	
	@RequestMapping("/main")
	public String main() { 
		return "main";
	}
	
	@RequestMapping("/xxx")
	public LoginDTO xxx() { // LoginDTO를 모델로 인식하고 xxx.jsp를 유추해서 찾음
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid("홍길동");
		dto.setPasswd("1234");
		
		return dto;
	}
	
	@RequestMapping("/yyy")
	@ResponseBody
	public LoginDTO yyy() { // LoginDTO ==변경==> JSON
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid("홍길동");
		dto.setPasswd("1234");
		
		return dto; // 로그인DTO를 리턴 -> JSON으로 변환
		// LoginDTO는 모델로 인식, xxx를 뷰정보로 인식
		// 하지만 지금은 LoginDTO를 모델로 인식하면 안됨 (JSON으로 변환되어야 되기 때문)
		// 이러한 인식을 막아주기 위해 @ResponseBody를 사용
	}
	
	@RequestMapping("/zzz")
	@ResponseBody
	public ArrayList<LoginDTO> zzz() { // ArrayList ==변경==> JSON
		
		ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
		list.add(new LoginDTO("Aaa1", "1234"));
		list.add(new LoginDTO("Aaa2", "1234"));
		list.add(new LoginDTO("Aaa3", "1234"));
		
		return list;
	}
}