package com.xb.Interface;

public class Student implements Singing,Dance {

	@Override
	public void dance() {
		System.out.println("我会跳舞");
	}

	@Override
	public void sing() {
		System.out.println("我会唱歌");
	}

	public static void main(String[] args) {
		Student student = new Student();
		student.sing();
		student.dance();
	}
}
