package ocm.ls.test;

import java.util.Scanner;

public class Shuiguo {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		Main sy=new Main();
		System.out.println("请输入一个水果"); 
		sy.sg=sc.next();
		System.out.println("请输入重量"); 
		sy.zl=sc.nextDouble();
		System.out.println("请输入你的金额");
		sy.sj=sc.nextDouble();
		sy.main();
	}

}
