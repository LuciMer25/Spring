package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	// junit 동작이 되는지(성공 => 1 success  2. error / 실패 => fail) 
	@Autowired
	EmpMapper empMapper;
	
//	@Test
	void contextLoads() {
		assertNotNull(empMapper);
		// assertNotNull 매개변수로 넘어간 값이 null이 아닌지 확인
	}
	
//	@Test
	void selectEmpAll() {
		// 전체조회
		List<EmpVO> list = empMapper.selectEmpAll();
		assertTrue(!list.isEmpty());
		// List type은 결과가 없어도 null이 아님 List는 어떠한 경우에도 null이 될 수 없음
	}
	
//	@Test
	void selectEmpInfo() {
		// 단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(114);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getEmpname(), "Den");
	}
	
	@Test
	void insertEmpInfo() {
		// 등록
		EmpVO empVO = new EmpVO();
		empVO.setEmpname("Hong");
		empVO.setSal(1000);
		empVO.setDeptid(40);
		
		int result = empMapper.insertEmpInfo(empVO);
//		assertEquals(result, 1);
		assertEquals(empVO.getEmpid(), 204);
	}
	
//	@Test
	void updateEmpInfo() {
		// 1.단건조회 => 2.업데이트
		// 1-1) 조건
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(2);
		
		// 1-2) 조회
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		findVO.setEmpname("Hong");
		findVO.setMgr(114);
		
		int result 
			= empMapper.updateEmpInfo(findVO.getEmpid(), findVO);
		
		assertEquals(1, result);
	}
	
//	@Test
	void deleteEmpInfo() {
		int result = empMapper.deleteEmpInfo(2);
		
		assertEquals(1, result);
	}

}
