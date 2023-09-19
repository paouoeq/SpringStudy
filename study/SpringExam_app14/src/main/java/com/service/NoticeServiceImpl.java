package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.NoticeDAO;
import com.dto.NoticeDTO;
import com.dto.PageDTO;

@Service("service")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDAO dao;
	
	@Override
	public PageDTO list(int curPage) {
		return dao.list(curPage);
	}

	@Override
	public int write(NoticeDTO dto) {
		return dao.write(dto);
	}

	@Transactional
	@Override
	public NoticeDTO findOne(int no) {
		int n = dao.cntUp(no);
		return dao.findOne(no);
	}

	@Override
	public int update(NoticeDTO dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int no) {
		return dao.delete(no);
	}

}
