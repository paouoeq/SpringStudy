package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ExDTO;
import com.dto.PageDTO;

@Repository("dao")
public class ExDAO {

	@Autowired
	SqlSessionTemplate session;
	
	// 목록보기
//	public List<ExDTO> findAll() {
//		return session.selectList("ExMapper.findAll");
//	}
	
	// 검색
//	public List<ExDTO> findAll(Map<String, String> map) {
//		return session.selectList("ExMapper.findAll", map);
//	}
	
	// 페이지추가
	public PageDTO findAll(Map<String, String> map, int curPage) {
		PageDTO pageDTO = new PageDTO();
		
		int offset = (curPage-1)*pageDTO.getPerPage(); // 시작위치 -> 페이지마다 다름 -> (현재페이지-1)*페이지당 보여줄 개수
		int limit = pageDTO.getPerPage(); // 한페이지당 보여줄 레코드 개수
		
		List<ExDTO> list = session.selectList("ExMapper.findAll", map, new RowBounds(offset, limit));
		
		// pageDTO에 list, totalCount, curPage 저장
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		int totalCount=0; // 초기화
		if(map.get("searchValue")==null) {
			// 검색을 안 한 경우
			totalCount=session.selectOne("ExMapper.totalCount");
		}
		else {
			// 검색을 한 경우
			totalCount=session.selectOne("ExMapper.totalCountSearch", map);
		}
		pageDTO.setTotalCount(totalCount);
		
		/* searchName과 searchValue를 PageDTO에 저장해야 함 -> 그래야 검색했을 때 페이징이 적용된다.
		searchName과 searchValue 유지를 시켜야 다른 페이지로 이동해도 검색조건이 유지가 된다.*/
		pageDTO.setSearchName(map.get("searchName"));
		pageDTO.setSearchValue(map.get("searchValue"));
	
		return pageDTO;
	}
	
	// 추가
	public int add(ExDTO dto) {
		return session.insert("ExMapper.add", dto);
	}
	
	// 삭제
	public int del(int no) {
		return session.delete("ExMapper.del", no);
	}
	
	// 자세히보기
	public ExDTO findNo(int no) {
		return session.selectOne("ExMapper.findNo", no);
	}
	
	// 수정
	public int update(ExDTO dto) {
		return session.update("ExMapper.update", dto);
	}
}
