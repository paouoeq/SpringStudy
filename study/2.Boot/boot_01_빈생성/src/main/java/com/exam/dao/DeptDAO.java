package com.exam.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class DeptDAO {

	public DeptDAO() {
		System.out.println("DeptDAO 생성");
	}
}
