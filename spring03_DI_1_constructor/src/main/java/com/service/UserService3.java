package com.service;

import java.util.List;

import com.dao.UserDAO;

public class UserService3 {
	
	UserDAO dao;
	public int num;

	public UserService3() {
		// TODO Auto-generated constructor stub
	}

	public UserService3(UserDAO dao) {
		this.dao = dao;
	}
	
	public UserService3(UserDAO dao2, int num2) {
		this.dao = dao2;
		this.num = num2;
	}
	
	public List<String> list() {
		return dao.list();
	}
	
}
