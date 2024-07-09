package com.yedam.spring.xml;

public class Restaurant {
	private Chef chef;
	
	Restaurant(Chef chef){
		System.out.println("생성자 인젝션");
		this.chef = chef;
	}
	
	Restaurant(){}
	
	public void setChef(Chef chef) {
		System.out.println("세터 인젝션");
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
