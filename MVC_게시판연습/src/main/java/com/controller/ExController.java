package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.ExDTO;
import com.dto.PageDTO;
import com.service.ExService;

@Controller
public class ExController {

	@Autowired
	ExService service;
	
	// 목록보기
//	@GetMapping("/findAll")
//	public String findAll(Model m) {
//		
//		// 모델
//		List<ExDTO> list = service.findAll();
//		m.addAttribute("list", list);
//		
//		// 뷰
//		return "list";
//	}
	
	// 검색
//	@GetMapping("/findAll")
//	public String findAll(HttpServletRequest request, Model m) {
//		
//		String searchName = request.getParameter("searchName");
//		String searchValue = request.getParameter("searchValue");
//		System.out.println(searchName + " " + searchValue);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("searchName",searchName);
//		map.put("searchValue",searchValue);
//		
//		List<ExDTO> list = service.findAll(map);
//		m.addAttribute("list", list);
//		
//		return "list";
//	}
	
	// 페이지 추가
	@GetMapping("/findAll")
	public String findAll(HttpServletRequest request, Model m) {
		
		String curPage = request.getParameter("curPage");
		if(curPage == null) {
			// 맨 처음 실행한 경우 : 현재 페이지=1
			curPage="1";
		}
		
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchName",searchName);
		map.put("searchValue",searchValue);
		
		PageDTO pageDTO = service.findAll(map, Integer.parseInt(curPage));
		
		m.addAttribute("PageDTO", pageDTO);
		
		return "list";
	}
	
	// 추가 화면
	@GetMapping("/addForm")
	public String addForm() {
		return "write";
	}
	
	// 추가
	@PostMapping("/add")
	public String add(ExDTO dto) {
		
		service.add(dto);
		return "redirect:findAll";
	}
	
	// 삭제
	@GetMapping("/del")
	public String del(@RequestParam int no) {
		
		service.del(no);
		return "redirect:findAll";
	}
	
	// 수정 화면
	@GetMapping("/findNo")
	public String findNo(@RequestParam int no, Model m) {
		
		ExDTO dto = service.findNo(no);
		m.addAttribute("ex", dto);
		
		return "list2";
	}
	
	// 수정
	@PostMapping("/update")
	public String update(ExDTO dto) {
		
		service.update(dto);
		return "redirect:findAll";
	}
	
}
