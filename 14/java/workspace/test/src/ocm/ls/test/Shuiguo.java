package ocm.ls.test;

import java.util.Scanner;

public class Shuiguo {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		Main sy=new Main();
		System.out.println("������һ��ˮ��"); 
		sy.sg=sc.next();
		System.out.println("����������"); 
		sy.zl=sc.nextDouble();
		System.out.println("��������Ľ��");
		sy.sj=sc.nextDouble();
		sy.main();
	}

}