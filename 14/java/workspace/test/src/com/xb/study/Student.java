package com.xb.study;

public class Student extends Human {

	private String classNumber;
	
	public void study() {
		System.out.println("我学了个寂寞");
	}
	
	public void study(String course) {
		System.out.println("我学了"+course);
	}
	
	public void study(int num,String course) {
		System.out.println("我在第"+num+"节课，学习了"+course);
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("我是学生，我在吃泡面");
	}
}
