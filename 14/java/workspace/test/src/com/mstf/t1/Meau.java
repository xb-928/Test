package com.mstf.t1;

import java.util.Scanner;

public class Meau {

	private static Cinema cinema;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		init();
		showMeau();
	}
	
	private static void init() {
		cinema = new Cinema();
		scanner = new Scanner(System.in);
	}
	
	private static void showMeau() {
		System.out.println("--------欢迎来到豪华影院管理系统--------");
		System.out.println("1：添加电影");
		System.out.println("2.查看已有的电影");
		System.out.println("任意字符：退出系统");
		System.out.print("输入数字选择您想要进行的操作：");
		String tag = scanner.next();
		
		if(tag.equals("1")) {
			addMovie();
		}else if(tag.equals("2")) {
			showMovie();
		}else {
			System.out.println("本系统已退出！");
		}
	}
	
	private static void addMovie() {
		System.out.println("请输入电影的名字：");
		String name = scanner.next();
		System.out.println("请输入电影的类型：");
		String type = scanner.next();
		System.out.println("请输入电影价格(输入整数)：");
		int price = scanner.nextInt();
		Movie movie = new Movie(name,type,price);
		cinema.addMovie(movie);
		System.out.println("电影添加成功！");
		showMeau();
	}
	
	private static void showMovie() {
		cinema.showMovie();
		showMeau();
	}

}
