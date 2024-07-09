package com.yedam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	
	public static void main(String[] args) {
		ApplicationContext ctx
//		ApplicationContext = 컨테이너를 생성하는 최상위 인터페이스(즉시 로딩)
		= new GenericXmlApplicationContext("classpath:applicaionContext.xml");
		
		TV tv = (TV) ctx.getBean("tv");
//		beans id="tv" 
		tv.turnOn();
		
		TV subTv = (TV) ctx.getBean(TV.class);
//		TV.class tv에 대한 클래스 정보 전체 (클래스 속성)
		subTv.turnOn();
		
		if( tv == subTv) {
//			동등비교('==') 메모리주소가 같은지 다른변수지만 같은 대상(객체)를 참조
			System.out.println("같은 인스턴스 입니다.");
		} else {
			System.out.println("다른 인스턴스 입니다.");
		}
	}
}	
