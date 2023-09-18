package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExDAO;
import com.dto.ExDTO;
import com.dto.PageDTO;

@Service("service")
public class ExServiceImpl implements ExService {

	@Autowired
	ExDAO dao;
	
	// 목록보기
//	@Override
//	public List<ExDTO> findAll() {
//		return dao.findAll();
//	}
	
	// 검색
	@Override
	public PageDTO findAll(Map<String, String> map, int curPage) {
		return dao.findAll(map, curPage);
	}
	
	// 추가
	@Override
	public int add(ExDTO dto) {
		return dao.add(dto);
	}

	// 삭제
	@Override
	public int del(int no) {
		return dao.del(no);
	}
	
	// 자세히보기
	@Override
	public ExDTO findNo(int no) {
		return dao.findNo(no);
	}

	// 수정
	@Override
	public int update(ExDTO dto) {
		return dao.update(dto);
	}


}
