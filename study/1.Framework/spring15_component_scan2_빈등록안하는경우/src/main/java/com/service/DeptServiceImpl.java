package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.DeptDAO;

//괄호 -> 이름 넣어주면 xml에서 id 지정한 것과 동일 (생략가능)
//@Component("service")
@Service("service") // 권장
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDAO dao;
	
	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl 생성자");
	}
	@Override
	public List<String> list() {
		return dao.list();
	}

}
