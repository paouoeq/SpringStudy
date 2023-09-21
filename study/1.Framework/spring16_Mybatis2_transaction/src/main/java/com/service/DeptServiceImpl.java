package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DeptDAO;
import com.dto.DeptDTO;

@Service("deptService")
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptDAO dao; // 마킹을 통해 빈 등록했음 -> autowired로 dao 생성 가능

	@Override
	public List<DeptDTO> deptList() {
		return dao.deptList();
	}

	// 스프링에서는 DML 작업시 자동으로 commit 된다.
	@Override
	public int deptAdd(DeptDTO dto) {
		return dao.deptAdd(dto);
	}

	@Override
	public int deptUpdate(DeptDTO dto) {
		return dao.deptUpdate(dto);
	}

	@Override
	public int deptDelete(int deptno) {
		return dao.deptDelete(deptno);
	}

	// 트랜잭션 실습
	@Transactional
	@Override
	public int tx() {
		//////////////트랜잭션/////////////////////
		// insert
		DeptDTO dto = new DeptDTO(4,"개발","서울");
		dao.deptAdd(dto);
		
		// delete
		dao.deptDelete(91);
		////////////////////////////////////////
		return 0;
	}

}
