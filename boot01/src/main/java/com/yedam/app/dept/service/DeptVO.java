package com.yedam.app.dept.service;

import java.util.Date;

import lombok.Data;

@Data
public class DeptVO {
	private Integer deptno;
	private String dname;
	private String loc;
	private Date hiredate;
	
}
