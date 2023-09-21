package com.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// 괄호 -> 이름 넣어주면 xml에서 id 지정한 것과 동일 (생략가능)
//@Component("dao")
@Repository("dao") // 권장
public class DeptDAO {

	public DeptDAO() {
		System.out.println("DeptDAO 생성자");
	}

	public List<String> list() {
		return Arrays.asList("홍길동", "이순신");
	}
}
