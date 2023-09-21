package com.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate session;
	
	// id 중복체크
	public MemberDTO idCheck(String userid) {
		return session.selectOne("MemberMapper.idCheck", userid);
	}
	
	// 회원가입
	public int memberAdd(MemberDTO dto) {
		return session.insert("MemberMapper.memberAdd", dto);
	}
	
	// 로그인
	public MemberDTO login(HashMap<String,String> map) {
		return session.selectOne("MemberMapper.login", map);
	}
	
	// 마이페이지 - id에 해당하는 유저 정보 반환
	public MemberDTO mypage(String userid) {
		return session.selectOne("MemberMapper.mypage", userid);
	}
	
	public MemberDTO emailCheck(HashMap<String,String> map) {
		return session.selectOne("MemberMapper.emailCheck", map);
	}
}
