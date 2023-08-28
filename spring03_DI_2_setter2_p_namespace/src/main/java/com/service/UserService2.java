package com.service;

public class UserService2 {
	int num;
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setUsername 메서드");
		this.username = username;
	}

	public void setNum(int num) {
		System.out.println("setNum 메서드");
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
}
