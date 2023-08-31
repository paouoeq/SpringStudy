package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DeptDAO;
import com.dto.DeptDTO;

@Service("service")
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDAO dao;

	@Override
	public List<DeptDTO> findAll() {
		return dao.findAll();
	}

}
