package com.xb.Interface;

public class Student implements Singing,Dance {

	@Override
	public void dance() {
		System.out.println("�һ�����");
	}

	@Override
	public void sing() {
		System.out.println("�һᳪ��");
	}

	public static void main(String[] args) {
		Student student = new Student();
		student.sing();
		student.dance();
	}
}
