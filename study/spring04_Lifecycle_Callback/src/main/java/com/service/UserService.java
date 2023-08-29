package com.service;

public class UserService {

	public UserService() {
		System.out.println("UserService 생성자");
	}

	//init-method="xxx"
	public void xxx() { // 리턴타입은 꼭 void, 파라미터 없어야 한다.
		System.out.println("생성자 호출 후 xxx 호출");
	}
	
	//destroy-method="yyy"
	public void yyy() { // 리턴타입은 꼭 void, 파라미터 없어야 한다.
		System.out.println("yyy 호출");
	}
	
}
