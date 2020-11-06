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
		System.out.println("--------��ӭ��������ӰԺ����ϵͳ--------");
		System.out.println("1����ӵ�Ӱ");
		System.out.println("2.�鿴���еĵ�Ӱ");
		System.out.println("�����ַ����˳�ϵͳ");
		System.out.print("��������ѡ������Ҫ���еĲ�����");
		String tag = scanner.next();
		
		if(tag.equals("1")) {
			addMovie();
		}else if(tag.equals("2")) {
			showMovie();
		}else {
			System.out.println("��ϵͳ���˳���");
		}
	}
	
	private static void addMovie() {
		System.out.println("�������Ӱ�����֣�");
		String name = scanner.next();
		System.out.println("�������Ӱ�����ͣ�");
		String type = scanner.next();
		System.out.println("�������Ӱ�۸�(��������)��");
		int price = scanner.nextInt();
		Movie movie = new Movie(name,type,price);
		cinema.addMovie(movie);
		System.out.println("��Ӱ��ӳɹ���");
		showMeau();
	}
	
	private static void showMovie() {
		cinema.showMovie();
		showMeau();
	}

}
