package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller // 사용자의 요청(endPoint)에 대한 처리를 정
public class EmpController {
	//해당 컨트롤러에서 서비스를 추가
	//autowirde
	 EmpService empService;
	 
	 // GET : 조회, 빈페이지
	 // POST : 데이터 조작(등록, 수정, 삭제)
	 
	 
	 //전체조회
	 @GetMapping("empList")
	 public String empList(Model model) { // model = Ruqest + 
		 
		//1) 기능수행
		List<EmpVO> list = empService.empList();
	 
		 //2) 클라이언트에 전달할 데이터 담기
		 model.addAttribute("empList", list);
		 //3) 데이터를 출력할 페이지 결정
		return "emp/list";
 }
	 
	 //단건조회
	 @GetMapping("empInfo") //커맨드 객체 => application/x-www-form-urlencoded
	 public String empInfo(EmpVO empVO, Model model) {
		 EmpVO findVO = empService.empInfo(empVO);
		 model.addAttribute("empInfo", findVO);
		 return "emp/info";
	 }
	 
	 //등록 - 페이지
	 @GetMapping("empInsert")
	 public String empInsertForm() {
		 return "emp/insert";
	 }
	 
	 //등록 - 처리(연산, submit) 
	 //커맨드객체 or JSON객체 / 등록할떄 submit = Form JSON불가 => 커맨드객체 사용
	 //경로가 같아도 메소드가 다르면 실행이 다름
	 @PostMapping("empInsert") 
	 public String empInsertProcess(EmpVO empVO) {
		 int eid = empService.empInsert(empVO);
		 // 후속처리 redirect 스프링에서는 
		 String url = null;
		 if( eid > -1) {
			 // 정상적으로 등록된 경우
			 url = "redirect:empInfo?empid=" + eid;
		 } else {
			 // 등록 실패한 경우
			 url = "redirect:empList";
		 }
		 return url;
	 }
	 	
	 //수정 - 페이지
	 
	 //수정 - 처리(연산, AJAX => (QueryString)
	 //수정 - 처리(연산, AJAX => Json)
	 //삭제 - 처리
	 
 }
