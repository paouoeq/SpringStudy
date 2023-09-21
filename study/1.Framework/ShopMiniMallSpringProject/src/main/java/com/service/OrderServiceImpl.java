package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO dao;
	
	@Override
	public CartDTO cartByNum(int num) {
		return dao.cartByNum(num);
	}

	@Override
	public MemberDTO memberByUserid(String userid) {
		return dao.memberByUserid(userid);
	}

	@Override
	@Transactional // dao.orderDone(dto)와 dao.cartDel(del_num) 모두 성공해야 자동 commit / 아니면 자동 rollback
	public int orderDone(OrderDTO dto, int del_num) {
		// 트랜잭션 시작
			
		// orderinfo에 저장
		int n = dao.orderDone(dto);
		// cart에서 삭제
		n = dao.cartDel(del_num);
			
		// 트랜잭션 종료
		return n;
	}	

}
