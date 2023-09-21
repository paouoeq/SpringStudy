package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/goodsRetrieve") // /WEB-INF/views/goodsRetrieve.jsp
	@ModelAttribute("goodsRetrieve") // 명시적으로 GoodsDTO의 키값 지정
	public GoodsDTO goodsRetrieve(@RequestParam String gCode) {
		
		GoodsDTO dto = goodsService.goodsRetrieve(gCode);
		
		return dto;
	}
	
	@GetMapping("/CartAddServlet")
	public String cartAdd(HttpSession session, CartDTO cartDTO) {
		// 로그인 체크
		
		// userid 얻기 위해 session, MemberDTO 필요
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		String userid = dto.getUserid();
		cartDTO.setUserid(userid);
		
		int n = cartService.cartAdd(cartDTO);
		
		return "goods/cartAddSuccess";
	}
	
	@GetMapping("/CartListServlet")
	public ModelAndView cartList(HttpSession session) {
		// 로그인 체크
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		
		List<CartDTO> list = cartService.cartList(userid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartList", list); // 모델 저장
		mav.setViewName("cartList"); // 뷰 저장
		
		return mav;
	}
	
	@GetMapping("/CartUpdateServlet") 
	@ResponseBody // ajax 처리하기 때문에 화면이 필요 없음 => 응답 불필요
	public void cartUpdate(@RequestParam HashMap<String, Integer> map) {
		// 로그인 체크
		int n = cartService.cartUpdate(map);
	}
	
	@GetMapping("/CartDeleteServlet")
	public String cartDelete(@RequestParam int num) {
		// 로그인 체크
		int n = cartService.cartDelete(num);
		return "redirect:CartListServlet";
	}
	
	@GetMapping("/CartDeleteAllServlet")
	public String cartDeleteAll(HttpServletRequest request) {
		// 로그인 체크
		String[] check = request.getParameterValues("check");
		List<String> del_list = Arrays.asList(check);
		int n = cartService.cartDeleteAll(del_list);
		return "redirect:CartListServlet";
	}
}
