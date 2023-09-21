package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	// 카테고리에 해당하는 상품목록 모두 출력
	public List<GoodsDTO> goodsList(String gCategory) {
		return session.selectList("GoodsMapper.goodsList", gCategory);
	}
	
	// 상품 자세히 보기
	public GoodsDTO goodsRetrieve(String gCode) {
		return session.selectOne("GoodsMapper.goodsRetrieve", gCode);
	}
}
