package com.dao;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.DeptDTO;

// 괄호 -> 이름 넣어주면 xml에서 id 지정한 것과 동일 (생략가능)
//@Component("dao")
@Repository("dao") // 권장
public class DeptDAO {

	@Autowired
	SqlSessionTemplate session;
	
	public List<DeptDTO> findAll() {
		return session.selectList("DeptMapper.findAll");
	}

}
