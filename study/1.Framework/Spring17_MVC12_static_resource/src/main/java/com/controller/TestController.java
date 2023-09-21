package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/") // http://localhost:8090/app/
	public String home() {
		
		return "main";
	}
}
