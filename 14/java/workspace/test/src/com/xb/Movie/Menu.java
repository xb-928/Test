package com.xb.Movie;

import java.util.Scanner;

public class Menu {

	private static Cinema cinema = new Cinema();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		showMenu();
	}
	
	private static void showMenu() {
		System.out.println("--------欢迎来到豪华影院管理系统--------");
		System.out.println("1.添加电影");
		System.out.println("2.查看电影");
		System.out.println("3.随机放映一部电影");
		System.out.println("任意字符，退出系统");
		System.out.print("输入数字选择您想要进行的操作：");
		String num = scanner.next();
		if("1".equals(num)) {
			addMovie();
		}else if("2".equals(num)) {
			showMovie();
		}else if("3".equals(num)) {
			cinema.playMovie();
			showMenu();
		}else {
			System.out.println("系统已退出！");
		}
	}
	
	public static void addMovie() {
		System.out.print("请输入电影的名称：");
		String name = scanner.next();
		System.out.print("请输入电影的类型：");
		String type = scanner.next();
		System.out.print("请输入电影的价格(输入整数)：");
		int price = scanner.nextInt();
		Movie movie = new Movie(name, type, price);
		cinema.addMovie(movie);
		System.out.println("电影添加成功！");
		showMenu();
	}
	
	public static void showMovie() {
		cinema.showMovie();
		showMenu();
	}
}
