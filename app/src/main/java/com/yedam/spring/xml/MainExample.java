package com.yedam.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicaionContext.xml");

		Restaurant res = (Restaurant)ctx.getBean(Restaurant.class);
		
		
		res.run();
	}
}
