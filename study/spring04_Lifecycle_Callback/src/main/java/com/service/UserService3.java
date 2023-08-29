package com.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserService3{

	public UserService3() {
		System.out.println("UserService3 생성자");
	}

	@PostConstruct
	public void xxx() {
		System.out.println("생성자 호출 후 @PostConstruct.xxx()호출");
	}
	
	@PreDestroy
	public void yyy() {
		System.out.println("@PreDestroy.yyy() 호출");
	}
}
