package com.service;

import java.util.Map;

import com.dto.Cat;

public class UserService3 {

	// 순서 없고 중복 불가
	Map<String, Cat> catMap;

	public Map<String, Cat> getCatMap() {
		return catMap;
	}

	// setter 메서드 주입
	public void setCatMap(Map<String, Cat> catMap) {
		this.catMap = catMap;
	}
	
	
	
}
