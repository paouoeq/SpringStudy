package com.service;

import com.dto.NoticeDTO;
import com.dto.PageDTO;

public interface NoticeService {
	
	// 전체목록
	public PageDTO list(int curPage);
	
	// 글쓰기
	public int write(NoticeDTO dto);
	
	// 자세히보기 + 조회수증가
	public NoticeDTO findOne(int no);
	
	// 글 수정
	public int update(NoticeDTO dto);
	
	// 글 삭제
	public int delete(int no);
}
