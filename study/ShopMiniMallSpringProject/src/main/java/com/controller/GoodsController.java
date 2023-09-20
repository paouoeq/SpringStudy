package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService service;
	
	@Autowired
	CartService service2;
	
	@GetMapping("/goodsRetrieve") // /WEB-INF/views/goodsRetrieve.jsp
	@ModelAttribute("goodsRetrieve") // 명시적으로 GoodsDTO의 키값 지정
	public GoodsDTO goodsRetrieve(@RequestParam String gCode) {
		
		GoodsDTO dto = service.goodsRetrieve(gCode);
		
		return dto;
	}
	
	@GetMapping("/CartAddServlet")
	public String cartAdd(HttpSession session, CartDTO cartDTO) {
		// 로그인 체크
		
		// userid 얻기 위해 session, MemberDTO 필요
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		String userid = dto.getUserid();
		cartDTO.setUserid(userid);
		
		int n = service2.cartAdd(cartDTO);
		
		return "goods/cartAddSuccess";
	}
}
