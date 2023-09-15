package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.LoginDTO;

@Controller 
public class TestController {
	
	// 1. 리턴타입 : String - 뷰 정보 O | 모델 정보 X
	@RequestMapping("string")
	public String fun() {
		System.out.println("string 요청");
		return "hello";
	}
	
	// 2. 리턴타입 : String, 파라미터 : Model - 뷰 정보 O | 모델 정보 O
	// 파라미터는 Model뿐만 아니라 다른 것도 모두 해당된다.(ex. Map, LoginDTO, ...)
	@RequestMapping("string_model")
	public String fun2(Model m) {
		System.out.println("string_model 요청");
		m.addAttribute("userid", "홍길동");
		return "hello2";
	}
	
	// 3. 리턴타입 : ModelAndView - 뷰 정보 O | 모델 정보 O
	@RequestMapping("mav")
	public ModelAndView fun3() {
		System.out.println("mav 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello2");
		mav.addObject("userid", "홍길동");
		return mav;
	}
	
	// 4. 리턴타입 : LoginDTO - 뷰 정보 X | 모델 정보 O
	// 뷰정보는 스프링이 유추해서 찾음 => 요청맵핑값을 뷰정보로 대신함 => ddd.jsp
	@RequestMapping("ddd")
	public @ModelAttribute("xyz") LoginDTO fun4() {
		System.out.println("ddd 요청");
		LoginDTO dto = new LoginDTO("hong", "12324");
		return dto;
	}
	
	// 5. 리턴타입 : ArrayList<LoginDTO> - 뷰 정보 X | 모델 정보 O
	// 뷰정보는 스프링이 유추해서 찾음 => 요청맵핑값을 뷰정보로 대신함 => eee.jsp
	@RequestMapping("eee")
	public @ModelAttribute("kkk") ArrayList<LoginDTO> fun5() {
		System.out.println("eee 요청");
		ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
		list.add(new LoginDTO("hong1", "1234"));
		list.add(new LoginDTO("hong2", "5678"));
		return list;
	}
	
	
	// 6. 리턴타입 : void - 뷰 정보 X | 모델 정보 X
	// 뷰정보는 스프링이 유추해서 찾음 => 요청맵핑값을 뷰정보로 대신함 => fff.jsp
	@RequestMapping("fff")
	public void fun6() {
		System.out.println("fff 요청");
	}
	
	// 7. 리턴타입 : void, 파라미터 : Model - 뷰 정보 X | 모델 정보 O
	// 뷰정보는 스프링이 유추해서 찾음 => 요청맵핑값을 뷰정보로 대신함 => ggg.jsp
	@RequestMapping("ggg")
	public void fun7(Model m) {
		System.out.println("ggg 요청");
		m.addAttribute("userid", "홍길동");
	}
	
	
}
