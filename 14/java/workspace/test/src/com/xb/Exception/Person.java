package com.xb.Exception;

import java.util.Scanner;

public class Person {

	public static void testAge(int age) throws WrongAgeException{
		if(age<0 || age>150) {
			throw new WrongAgeException("�������䲻���Ϲ淶");
		}else {
			System.out.println("��������Ϊ��"+age);
		}
	}
	
	
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		System.out.print("�������������䣺");
//		try {
//			testAge(input.nextInt());
//		}catch(WrongAgeException e){
//			e.printStackTrace();
//		}finally {
//			System.out.println("finally");
//		}
//	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������һ���ˣ�");
			isHuman(input.next());
	}
	
	public static void isHuman(String human) throws NotHumanException{
		if(!human.equals("��")) {
			throw new NotHumanException("��Ǹ������˲�����");
		}else {
			System.out.println(human);
		}
	}
	
}
