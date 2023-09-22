package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.dao.DeptDAO;
import com.exam.dto.DeptDTO;

@Service("xxx")
public class DeptServiceImple implements DeptService {
	
	DeptDAO dao;
	
	// 생성자로 주입 - 기본 생성자 제거 필수
	public DeptServiceImple(DeptDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<DeptDTO> deptList() {
		return dao.deptList();
	}
}
