package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.LoginDTO;

@Controller // controller 클래스 지정과 동시에 마킹도 한 것
public class TestController {
	
	@RequestMapping("/main")
	public String main() { 
		System.out.println("main");
		return "main";
	}
	
	@PostMapping("/yyy")
	public String yyy(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		System.out.println("yyy");
		return "main";
	}
	
	@PostMapping("/zzz")
	public String zzz(@RequestBody ArrayList<LoginDTO> list) {
		System.out.println(list);
		System.out.println("zzz");
		return "main";
	}
	
	
}