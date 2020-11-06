package com.xb.Exception;

import java.util.Scanner;

public class Person {

	public static void testAge(int age) throws WrongAgeException{
		if(age<0 || age>150) {
			throw new WrongAgeException("您的年龄不符合规范");
		}else {
			System.out.println("您的年龄为："+age);
		}
	}
	
	
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		System.out.print("请输入您的年龄：");
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
		System.out.println("请输入一个人：");
			isHuman(input.next());
	}
	
	public static void isHuman(String human) throws NotHumanException{
		if(!human.equals("人")) {
			throw new NotHumanException("抱歉，这个人不是人");
		}else {
			System.out.println(human);
		}
	}
	
}
