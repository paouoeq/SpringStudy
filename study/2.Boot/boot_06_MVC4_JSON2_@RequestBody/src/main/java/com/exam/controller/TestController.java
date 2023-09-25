package com.exam.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.dto.LoginDTO;

@Controller
public class TestController {
	
	// http://localhost:8090/app/main
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@PostMapping("/yyy")
	@ResponseBody // OK를 jsp가 아닌 데이터로 처리하기 위함
	public String yyy(@RequestBody LoginDTO dto) { // jsp에서 전달해주는 것들을 Logindto에 저장
		System.out.println(dto); // LoginDTO [userid=홍길동, passwd=1234]
		return "OK";
	}
	
	@PostMapping("/zzz")
	@ResponseBody // OK를 jsp가 아닌 데이터로 처리하기 위함
	public String zzz(@RequestBody ArrayList<LoginDTO> list) { // jsp에서 전달해주는 것들을 List에 저장
		System.out.println(list); // [LoginDTO [userid=홍길동1, passwd=1234], LoginDTO [userid=홍길동2, passwd=9999]]
		return "OK";
	}
}
