package com.xb.study;

public class Student extends Human {

	private String classNumber;
	
	public void study() {
		System.out.println("��ѧ�˸���į");
	}
	
	public void study(String course) {
		System.out.println("��ѧ��"+course);
	}
	
	public void study(int num,String course) {
		System.out.println("���ڵ�"+num+"�ڿΣ�ѧϰ��"+course);
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("����ѧ�������ڳ�����");
	}
}
