package com.service;

import java.util.Map;
import java.util.Properties;

import com.dto.Cat;

public class UserService4 {

	Properties phones;

	// setter 메서드 의존성 주입
	public void setPhones(Properties phones) {
		this.phones = phones;
	}
	
	public Properties getPhones() {
		return phones;
	}

}
