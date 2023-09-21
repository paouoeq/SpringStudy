package com.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

	String username;

	Cat cat;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	@Override
	public String toString() {
		return "Person [username=" + username + ", cat=" + cat + "]";
	}
	
}
