//package com.yedam.app.test.web;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.yedam.app.dept.service.DeptVO;
//
//
//@Controller
//public class ParamController2 {
//	// QueryString(질의문자열) : key=value&key=value&...
//	// method는 상관없음
//	// Content-type : application/x-www-form-urlencoded 
//	
//	// QueryString => 커맨드 객체 : 클래스 타입
//	
//	
//	@RequestMapping(path="comobj",
//			method= {RequestMethod.GET, RequestMethod.POST})
//	@ResponseBody
//	public String commandObject(DeptVO deptVO) {
//		String result = "";
//		result += "path : / comobj\n";
//		result += "\t deptno : " + deptVO.getDeptno();
//		result += "\t dname : " + deptVO.getDname();
//		return result;
//	}
//	
//	// QueryString => @RequestParam : 기본타입, 단일값
//	@RequestMapping(path="reqparam",
//			method= {RequestMethod.GET, RequestMethod.POST})
//	@ResponseBody
//	public String requestParam(
//			String dname, // 생략가능 
////			@RequestParam을 붙이면 반드시 필수, 없다면 생략
//			@RequestParam Integer deptno, // 필수 key(empid)
//			
//			@RequestParam(name="message", //name 속성을 쓰면 변수명을 덮어써서 msg가 아닌 message를 써야한다.
////						  사용자가 넘겨주는 값이 없다면 아래가 출력, 대신 사용할 값
//						  defaultValue = "No message", 
//						  required = true) String msg) {
//		String result = "";
//		result += "path : /reparam \n";
//		result += "\t deptno : " + deptno;
//		result += "\t dname : " + dname;
//		result += "\t message : " + msg;
//		return result;
//	}
//	
////	@PathVariable : 경로에 값을 포함하는 방식, 단일 값
////	Method, Content-type 상관없음
//	@RequestMapping(path = {"path/{id}/{pwd}", "path/{id}"}) 
//					// path/Hong/1234, path/1234/1234
//	@ResponseBody
//	public String pathVariable(@PathVariable String id,
//			@PathVariable(name = "pwd", required=false) String password) {
//		// 기본값 설정
//		if( password == null ) password = "1234";
//		
//		String result = "";
//		result += "path /path/{id}{pwd} \n";
//		result += "\t id : " + id;
//		result += "\t pwd : " + password;
//		return result;
//	}
//	
////	@RequestBody : Json 포맷, 배열 or 객체
////	Method : POST, PUT
////	Content-type : application/json
//	@PostMapping("resbody")
//	@ResponseBody
//	public String requestBody(@RequestBody DeptVO deptVO) {
//		String result = "";
//		result += "path : / resbody\n";
//		result += "\t deptno : " + deptVO.getDeptno();
//		result += "\t dname : " + deptVO.getDname();
//		return result;
//	}
//	
//	@PostMapping("resbodyList")
//	@ResponseBody
//	public String requestBodyList(
//								   @RequestBody List<DeptVO> list) {
//		String result = "path : /resobdyList \n";
//		for(DeptVO deptVO : list) {
//			result += "\t deptno : " + deptVO.getDeptno();
//			result += "\t dname : " +  deptVO.getDname();
//			result += "\n";
//		}
//		return result;
//	}
//	
//	
//}
