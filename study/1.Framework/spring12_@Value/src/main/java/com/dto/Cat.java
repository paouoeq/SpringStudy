package com.dto;

import org.springframework.beans.factory.annotation.Value;

public class Cat {
	
	@Value(value="홍길동")
	String username;
	
	@Value("2") // value 생략 가능, 무조건 문자열로 입력 => 자동 형변환됨
	int age;
	
	public Cat() { }
	public Cat(String username, int age) {
		this.username = username;
		this.age = age;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Cat [username=" + username + ", age=" + age + "]";
	}
}
