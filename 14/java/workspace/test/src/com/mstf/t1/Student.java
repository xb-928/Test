package com.mstf.t1;

import java.util.Scanner;

public class Student {

	String name;
	int score;
	public Student(String name) {
		this.name = name;
	}
	
	public class Teacher {
		String name;
		Teacher(String name){
			this.name = name;
		}
		public void show() {
			System.out.println(this.name);
		}
	}
//	String[] name = new String[10];
//	int[] score = new int[10];
//	public static void main(String[] args) {
//		Student student = new Student();
//		Scanner input = new Scanner(System.in);
//		for(int i=0;i<10;i++) {
//			System.out.print("�������"+(i+1)+"λͬѧ�����֣�");
//			student.name[i] = input.next();
//			System.out.print("�������"+(i+1)+"λͬѧ�ķ�����");
//			student.score[i] = input.nextInt();
//		}
//		System.out.println("�������£�");
//		for(int i=0;i<10;i++) {
//			System.out.print(student.name[i]+"\t"+student.score[i]+"\t\t");
//			if(i==4) {
//				System.out.println();
//			}
//		}
//	}
	
}
