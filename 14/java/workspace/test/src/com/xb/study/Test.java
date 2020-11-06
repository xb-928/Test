package com.xb.study;

public class Test {

	public static void main(String[] args) {

		Student student = new Student();
		Teacher teacher = new Teacher();
		
		student.eat();
		student.study();
		student.study("Java");
		student.study(2, "MySQL");
		
		teacher.eat();
		teacher.teach();
		teacher.teach("327°à");
	}

}
