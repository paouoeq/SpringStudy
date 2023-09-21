package com.dto;

public class Cat {

	String username;
	int age;
	
	// setter 메서드 주입
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getUsername() {
		return username;
	}
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Cat [username=" + username + ", age=" + age + "]";
	}
}
