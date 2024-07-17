package com.yedam.app.aaa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aaa.mapper.AaaMapper;
import com.yedam.app.aaa.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	
	@Autowired
	AaaMapper aaaMapper;
	
	
	@Transactional
	// 하나의 트랜젝션으로 묶을떄 하나라도 오류가 날 경우 전체 롤백(db 데이터가 들어가지 않음)
	@Override
	public void insert() {
		aaaMapper.aaaInsert("101");
		aaaMapper.aaaInsert("a101");	
	}
	
	

}
