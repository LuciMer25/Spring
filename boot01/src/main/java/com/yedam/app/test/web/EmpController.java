package com.yedam.app.test.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;





@Controller // 사용자의 요청(endPoint)에 대한 처리를 정
public class EmpController {
	//해당 컨트롤러에서 서비스를 추가
	@Autowired
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
		// classpath:/templates/ emp/list .html
		// prefix		          return   subfix
		// =>  classpath:/templates/emp/list.html
 }
	 
	 //단건조회
	 @GetMapping("empInfo") //커맨드 객체 => application/x-www-form-urlencoded
	 public String empInfo(EmpVO empVO, Model model) {
		 EmpVO findVO = empService.empInfo(empVO);
		 model.addAttribute("empInfo", findVO);
		 return "emp/info";
		 // classpath:/templates/emp/info.html
		 // classpath = src/main/resources ? 
	 }
	 
	 //등록 - 페이지
	 @GetMapping("empInsert")
	 public String empInsertForm() {
		 return "emp/insert";
		 //classpath:/templates/emp/insert.html
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
	 	
	 //수정 - 페이지 => 단건조회 
	 @GetMapping("empUpdate")
	 public String empUpdateForm(@RequestParam Integer empid,
			 						Model model) {
		 EmpVO empVO = new EmpVO();
		 empVO.setEmpid(empid);
		 
		 EmpVO findVO = empService.empInfo(empVO);
		 model.addAttribute("empInfo", findVO);
		 
		 return "emp/update";
	 }
	 
	 //수정 - 처리(연산, AJAX => (QueryString)
	 //@PostMapping("empUpdate")
	 @ResponseBody // => AJAX 
	 public Map<String, Object> empUpateAJAXQUERYSTRING(EmpVO empVO){
		 return empService.empUpdate(empVO);
	 }
	 
	 
	 //수정 - 처리(연산, AJAX => JSON : @RequestBody)
	 //AJAX가 항상 JSON을 요구하는것은 아님
	 @PostMapping("empUpdate")
	 @ResponseBody // => AJAX 
	 public Map<String, Object> empUpateAJAXJSON(@RequestBody EmpVO empVO){
		 return empService.empUpdate(empVO);
	 }
	 
	 //삭제 - 처리
	 // 여러개의 값 = post, 등록 수정은 AJAX를 주로 사용, 
	 @GetMapping("empDelete")
	 public String empDelete(EmpVO empVO) {
		 empService.empDelete(empVO);
		 return "redirect:empList";
	 }
	 
 }
