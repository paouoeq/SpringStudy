package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.OrderService;

@Controller
public class OderController {

	@Autowired
	OrderService service;
	
	@GetMapping("/OrderConfirmServlet")
	public String orderConfirm(@RequestParam int num, HttpSession session, Model m) {
		// 로그인 체크
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		CartDTO cDTO = service.cartByNum(num);
		String userid = dto.getUserid();
		MemberDTO mDTO = service.memberByUserid(userid);
		
		m.addAttribute("cDTO", cDTO);
		m.addAttribute("mDTO", mDTO);
		
		return "orderConfirm";
	}
	
	@GetMapping("/OrderDoneServlet")
	public String orderDone(HttpSession session, OrderDTO orderDTO, @RequestParam("num") int del_num, Model m) {
		// 로그인 체크
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		orderDTO.setUserid(userid);
		int n = service.orderDone(orderDTO, del_num);
		
		m.addAttribute("orderDTO", orderDTO);
		
		return "orderDone";
	}
}
