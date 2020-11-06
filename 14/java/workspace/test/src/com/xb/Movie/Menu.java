package com.xb.Movie;

import java.util.Scanner;

public class Menu {

	private static Cinema cinema = new Cinema();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		showMenu();
	}
	
	private static void showMenu() {
		System.out.println("--------��ӭ��������ӰԺ����ϵͳ--------");
		System.out.println("1.��ӵ�Ӱ");
		System.out.println("2.�鿴��Ӱ");
		System.out.println("3.�����ӳһ����Ӱ");
		System.out.println("�����ַ����˳�ϵͳ");
		System.out.print("��������ѡ������Ҫ���еĲ�����");
		String num = scanner.next();
		if("1".equals(num)) {
			addMovie();
		}else if("2".equals(num)) {
			showMovie();
		}else if("3".equals(num)) {
			cinema.playMovie();
			showMenu();
		}else {
			System.out.println("ϵͳ���˳���");
		}
	}
	
	public static void addMovie() {
		System.out.print("�������Ӱ�����ƣ�");
		String name = scanner.next();
		System.out.print("�������Ӱ�����ͣ�");
		String type = scanner.next();
		System.out.print("�������Ӱ�ļ۸�(��������)��");
		int price = scanner.nextInt();
		Movie movie = new Movie(name, type, price);
		cinema.addMovie(movie);
		System.out.println("��Ӱ��ӳɹ���");
		showMenu();
	}
	
	public static void showMovie() {
		cinema.showMovie();
		showMenu();
	}
}
