package com.xb.study;

public class Teacher extends Human {

	private String course;
	
	public void teach() {
		System.out.println("我放弃教书了");
	}
	
	public void teach(String classNumber) {
		System.out.println("我在教"+classNumber);
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("我是教师，我也能吃饭，还能喝汤");
	}
}
