package com.service;

import java.util.List;

import com.dao.UserDAO;

public class UserService {
	UserDAO dao;
	int num;
	String username;
	
	// 생성자 주입
	public UserService(UserDAO dao) {
		this.dao = dao;
	}
	
	// setter 메서드 주입
	public void setNum(int num) {
		this.num = num;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	// 호출용
	public int getNum() {
		return num;
	}
	public String getUsername() {
		return username;
	}
	public List<String> list() {
		return dao.list();
	}
}
