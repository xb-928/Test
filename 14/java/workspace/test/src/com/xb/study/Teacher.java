package com.xb.study;

public class Teacher extends Human {

	private String course;
	
	public void teach() {
		System.out.println("�ҷ���������");
	}
	
	public void teach(String classNumber) {
		System.out.println("���ڽ�"+classNumber);
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("���ǽ�ʦ����Ҳ�ܳԷ������ܺ���");
	}
}
