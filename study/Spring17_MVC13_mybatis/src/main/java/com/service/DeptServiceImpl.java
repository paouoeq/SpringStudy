package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DeptDAO;
import com.dto.DeptDTO;

@Service("service")
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDAO dao;
	
	// 목록보기
	@Override
	public List<DeptDTO> findAll() {
		return dao.findAll();
	}

	// 부서등록
	// 만약 트랜잭션 처리해야 된다면 @Transactional 추가하기
	@Override
	public int deptAdd(DeptDTO dto) {
		return dao.deptAdd(dto); // 자동커밋
	}

}
