package com.mstf.t1;

import java.util.Scanner;

public class ��λ��� {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("������һ����������ɵĴ�(<1000):");
		int num = input.nextInt();
		int finalnum;
		if(num<1000) {
			int num1 = num/100;
			int num2 = num/10%10;
			int num3 = num%10;
			finalnum = num1+num2+num3;
			if(finalnum<10) {
				System.out.println(finalnum);
			}else {
				int num4 = finalnum/10;
				int num5 = finalnum%10;
			}
		}else {
			System.out.println("����������ִ�������Ҫ��");
		}
	}

}
