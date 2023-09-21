package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class MainController {
	@Autowired
	GoodsService service; // 서블릿의 GoodsService service = new GoodsServiceImpl();
	
	@GetMapping("/main")
	public String main(@RequestParam(value="gCategory", required = false, defaultValue="top") String gCategory, Model m) {
		// required = false, defaultValue="top" 속성을 추가하여 넘어오는 값이 없어도(null) 오류가 안나게끔 설정
		
		List<GoodsDTO> list = service.goodsList(gCategory); // List<GoodsDTO> list가 모델
		
		m.addAttribute("goodsList", list); // request.setAttribute("goodsList",list)와 동일
		
		return "main"; // forward방식
	}
}
