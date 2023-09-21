package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.DeptDTO;

@Repository("deptDAO")
public class DeptDAO {
	
	@Autowired
	SqlSessionTemplate session; // bean으로 등록되어있어 Autowired로 생성 가능
	
	// 목록 보기
	public List<DeptDTO> deptList() {
		return session.selectList("DeptMapper.deptList");
	}
	
	public int deptAdd(DeptDTO dto) {
		return session.insert("DeptMapper.deptAdd", dto);
	}
	
	public int deptUpdate(DeptDTO dto) {
		return session.update("DeptMapper.deptUpdate", dto);
	}
	
	public int deptDelete(int deptno) {
		return session.delete("DeptMapper.deptDelete", deptno);
	}
	
}
