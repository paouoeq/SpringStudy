package com.exam.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	// 요청 URL : http://localhost:8090/app/board/num/10
	// 요청 URL : http://localhost:8090/app/board/10
	// => num값 10을 이용해 GET(select) 할 의도
	@GetMapping("/board/{num}") // num이라는 변수에 10이 저장됨
	public String aaa(@PathVariable("num") String num) {
		// @PathVariable("변수명") : url에 지정된 값을 변수에 저장
		System.out.println("@GetMapping : 조회용 "+num);
		return "get";
	}
	
	
	// 요청 URL : http://localhost:8090/app/board2/num/10/username/hong
	// 요청 URL : http://localhost:8090/app/board2/20/kim
	// => num값과 username값을 이용해 POST(insert) 할 의도
	@PostMapping("/board2/{num}/{username}")
	public String bbb(@PathVariable("num") String num, @PathVariable("username") String username) {
		System.out.println("@PostMapping : 저장용 "+num+"\t"+username);
		return "post";
	}
	
	// 요청 URL : http://localhost:8090/app/board2/20/kim
	// => num값과 username값 이용해 update할 의도
	@PutMapping("/board2/{num}/{username}") // 동일한 url 사용 가능(어노테이션이 다르기 때문)
	public String ccc(@PathVariable("num") String num, @PathVariable("username") String username) {
		System.out.println("@PutMapping : 수정용 "+num+"\t"+username);
		return "put";
	}
	
	// 요청 URL : http://localhost:8090/app/board2/20
	// => num값 이용해 delete할 의도
	@DeleteMapping("/board2/{num}")
	public String ddd(@PathVariable("num") String num) {
		System.out.println("@DeleteMapping : 삭제용 "+num);
		return "delete";
	}
	
}
