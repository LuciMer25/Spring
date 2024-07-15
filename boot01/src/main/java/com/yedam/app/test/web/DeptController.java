package com.yedam.app.test.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

public class DeptController {
	//해당 컨트롤러에서 서비스를 추가
		//autowirde
		 DeptService deptService;
		 
		 // GET : 조회, 빈페이지
		 // POST : 데이터 조작(등록, 수정, 삭제)
		 
		 
		 //전체조회
		 @GetMapping("deptList")
		 public String deptList(Model model) { // model = Ruqest + 
			 
			//1) 기능수행
			List<DeptVO> list = deptService.deptList();
		 
			 //2) 클라이언트에 전달할 데이터 담기
			 model.addAttribute("deptList", list);
			 //3) 데이터를 출력할 페이지 결정
			return "dept/list";
	 }
		 
		 //단건조회
		 @GetMapping("deptInfo") //커맨드 객체 => application/x-www-form-urlencoded
		 public String deptInfo(DeptVO deptVO, Model model) {
			 DeptVO findVO = deptService.deptInfo(deptVO);
			 model.addAttribute("deptInfo", findVO);
			 return "dept/info";
		 }
		 
		 //등록 - 페이지
		 @GetMapping("deptInsert")
		 public String deptInsertForm() {
			 return "dept/insert";
		 }
		 
		 //등록 - 처리(연산, submit) 
		 //커맨드객체 or JSON객체 / 등록할떄 submit = Form JSON불가 => 커맨드객체 사용
		 //경로가 같아도 메소드가 다르면 실행이 다름
		 @PostMapping("deptInsert") 
		 public String deptInsertProcess(DeptVO deptVO) {
			 int dno = deptService.deptInsert(deptVO);
			 // 후속처리 redirect 스프링에서는 
			 String url = null;
			 if( dno > -1) {
				 // 정상적으로 등록된 경우
				 url = "redirect:deptInfo?deptno=" + dno;
			 } else {
				 // 등록 실패한 경우
				 url = "redirect:deptList";
			 }
			 return url;
		 }
		 	
		 //수정 - 페이지
		 
		 //수정 - 처리(연산, AJAX => (QueryString)
		 //수정 - 처리(연산, AJAX => Json)
		 //삭제 - 처리
		 
}
