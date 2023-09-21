package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dto.DeptDTO;
import com.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService service;
	
	// 목록보기
	@GetMapping("/findAll")
	public String findAll(Model m) {
		
		// 모델
		List<DeptDTO> list = service.findAll();
		m.addAttribute("list", list); // 모델 생성 -> jsp에서 list 키값을 이용해 list를 보여줄 수 있음
		
		// 뷰
		return "list"; // /WEB-INF/views/list.jsp로 넘어감
	}
	
	// 부서등록 화면
	@GetMapping("/deptAddForm")
	public String deptAddForm() {
		return "write"; // /WEB-INF/views/write.jsp
	}
	
	// 부서등록
	@PostMapping("/deptAdd")
	public String deptAdd(DeptDTO dto) {
		// DetpDTO -> DAO까지 전달
		int n = service.deptAdd(dto);
		return "redirect:findAll"; // list를 요청하는게 아니라 findAll을 요청해야함 => 리다이렉트 사용
	}
}
