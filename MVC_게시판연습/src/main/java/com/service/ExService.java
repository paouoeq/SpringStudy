package com.service;

import java.util.Map;

import com.dto.ExDTO;
import com.dto.PageDTO;

public interface ExService {

	// 목록보기
//	public List<ExDTO> findAll();

	// 검색
//	public List<ExDTO> findAll(Map<String, String> map);
	
	// 페이지 추가
	public PageDTO findAll(Map<String, String> map, int curPage);
	
	// 추가
	public int add(ExDTO dto);
	
	// 삭제
	public int del(int no);
	
	// 자세히보기
	public ExDTO findNo(int no);
	
	// 수정
	public int update(ExDTO dto);
	
}
