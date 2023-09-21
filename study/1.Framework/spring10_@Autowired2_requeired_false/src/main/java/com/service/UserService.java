package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDAO;

public class UserService {

	// Autowired에 의해 xml에 등록된 빈 중 변수의 데이터타입과 일치하는 데이터타입이 있는지 찾음
	@Autowired(required = false)
	UserDAO dao;
	
	public List<String> list() {
		return dao.list();
	}
	
}
