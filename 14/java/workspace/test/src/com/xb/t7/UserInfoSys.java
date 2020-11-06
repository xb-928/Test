package com.xb.t7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInfoSys {

	Scanner input = new Scanner(System.in);
	UserInfo userInfo;
	List list = new ArrayList();
	
	public void add() {
		System.out.print("请输入账号：");
		String no = input.next();
		System.out.print("请输入姓名：");
		String name = input.next();
		System.out.print("请输入性别：");
		String sex = input.next();
		userInfo = new UserInfo(no, name, sex);
		list.add(userInfo);
	}
	public void addUserInfo() {
		this.add();
		System.out.println("添加用户成功！");
		System.out.println("当前系统所有用户信息："+list);
		this.show();
	}
	
	public void deleteUserInfo() {
		System.out.println("请输入要删除的编号：");
		String no = input.next();
		for(int i=0;i<list.size();i++) {
			userInfo = (UserInfo) list.get(i);
			if(userInfo.getNo().equals(no)) {
				list.remove(i);
				System.out.println("用户删除成功！");
				System.out.println("当前系统所有用户信息："+list);
				break;
			}
		}	
		this.show();
	}
	
	public void selectUserInfo() {
		System.out.println("【1】按编号查询 【2】按姓名查询 【3】按性别查询");
		int num = input.nextInt();
		if(num==1) {
			System.out.println("请输入编号：");
			String no = input.next();
			for(int i=0;i<list.size();i++) {
				userInfo = (UserInfo) list.get(i);
				if(userInfo.getNo().equals(no)) {
					System.out.println("查询到的用户数据："+userInfo);
					break;
				}
			}
		}else if(num==2){
			System.out.println("请输入姓名：");
			String name = input.next();
			for(int i=0;i<list.size();i++) {
				userInfo = (UserInfo) list.get(i);
				if(userInfo.getName().equals(name)) {
					System.out.println("查询到的用户数据："+userInfo);
					break;
				}
			}
		}else if(num==3) {
			System.out.println("请输入性别：");
			String sex = input.next();
			for(int i=0;i<list.size();i++) {
				userInfo = (UserInfo) list.get(i);
				if(userInfo.getSex().equals(sex)) {
					System.out.println("查询到的用户数据："+userInfo);
					break;
				}
			}
		}else {
			System.out.println("输入错误，请重新输入！");
			this.selectUserInfo();
		}
		this.show();
	}
	
	public void show() {
		System.out.println("请执行操作：【1】添加 【2】删除 【3】查询");
		int num = input.nextInt();
		if(num==1) {
			this.addUserInfo();
		}else if(num==2) {
			this.deleteUserInfo();
		}else if(num==3) {
			this.selectUserInfo();
		}else {
			System.out.println("输入错误，请重新输入！");
			this.show();
		}
	}
}
