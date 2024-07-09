package com.yedam.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	private Chef chef;
	
//	@Autowired
//	Annotation 이용시 (1.무엇을 이용할지 직관적, 2.xml 문법을 몰라도 됨) DI로 사용할 생성자 위 Autowired, Spring에게 이걸 쓰라고 알린다 
	Restaurant(Chef chef){
		System.out.println("생성자 인젝션");
		this.chef = chef;
	}
	
	Restaurant(){}
	@Autowired
	public void setChef(Chef chef) {
		System.out.println("세터 인젝션");
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
