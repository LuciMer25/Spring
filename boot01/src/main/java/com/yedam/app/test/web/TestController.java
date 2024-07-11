package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;


// web과 관련된 bin
@Controller
public class TestController {
	
	
	@RequestMapping("test")
	@ResponseBody
	public String userTest(String keyword) {
		return "Server Response : " + keyword;
	}
	
	// method get = 조회
//	@RequestMapping(path="/sample", method=RequestMethod.GET)
	@GetMapping("sample")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : SELECT " + keyword;
	}
	
	// method post = 등록
//	@RequestMapping(path="/sample", method=RequestMethod.POST)
	@PostMapping("sample")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Response : INSERT - " + keyword;
	}
	
	@GetMapping("param")
	public EmpVO paramGetTest(EmpVO empVO) {
		return empVO;
	}
	
	// 통신상의 모든 값은 텍스트로 보내기에 받을떄는 String 날짜나 숫자는 형변환을 시켜줘야함
}
