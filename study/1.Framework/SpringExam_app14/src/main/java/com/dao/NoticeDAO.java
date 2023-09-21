package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.NoticeDTO;
import com.dto.PageDTO;

@Repository("dao")
public class NoticeDAO {

	@Autowired
	SqlSessionTemplate session;
	
	// 전체목록
	public PageDTO list(int curPage) {
		PageDTO pageDTO = new PageDTO();
		
		int offset = (curPage-1)*pageDTO.getPerPage();
		int limit = pageDTO.getPerPage();
	
		List<NoticeDTO> list = session.selectList("NoticeMapper.list", null, new RowBounds(offset, limit));

		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		int totalCount = session.selectOne("NoticeMapper.totalCnt");
		pageDTO.setTotalCount(totalCount);

		return pageDTO;
	}
	
	// 글쓰기
	public int write(NoticeDTO dto) {
		return session.insert("NoticeMapper.write", dto);
	}
	
	// 자세히보기
	public NoticeDTO findOne(int no) {
		return session.selectOne("NoticeMapper.findOne", no);
	}
	
	// 조회수 증가
	public int cntUp(int no) {
		return session.update("NoticeMapper.cntUp", no);
	}
	
	// 글 수정
	public int update(NoticeDTO dto) {
		return session.update("NoticeMapper.update", dto);
	}
	
	// 글 삭제
	public int delete(int no) {
		return session.delete("NoticeMapper.delete", no);
	}
}
