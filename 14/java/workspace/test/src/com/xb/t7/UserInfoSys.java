package com.xb.t7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInfoSys {

	Scanner input = new Scanner(System.in);
	UserInfo userInfo;
	List list = new ArrayList();
	
	public void add() {
		System.out.print("�������˺ţ�");
		String no = input.next();
		System.out.print("������������");
		String name = input.next();
		System.out.print("�������Ա�");
		String sex = input.next();
		userInfo = new UserInfo(no, name, sex);
		list.add(userInfo);
	}
	public void addUserInfo() {
		this.add();
		System.out.println("����û��ɹ���");
		System.out.println("��ǰϵͳ�����û���Ϣ��"+list);
		this.show();
	}
	
	public void deleteUserInfo() {
		System.out.println("������Ҫɾ���ı�ţ�");
		String no = input.next();
		for(int i=0;i<list.size();i++) {
			userInfo = (UserInfo) list.get(i);
			if(userInfo.getNo().equals(no)) {
				list.remove(i);
				System.out.println("�û�ɾ���ɹ���");
				System.out.println("��ǰϵͳ�����û���Ϣ��"+list);
				break;
			}
		}	
		this.show();
	}
	
	public void selectUserInfo() {
		System.out.println("��1������Ų�ѯ ��2����������ѯ ��3�����Ա��ѯ");
		int num = input.nextInt();
		if(num==1) {
			System.out.println("�������ţ�");
			String no = input.next();
			for(int i=0;i<list.size();i++) {
				userInfo = (UserInfo) list.get(i);
				if(userInfo.getNo().equals(no)) {
					System.out.println("��ѯ�����û����ݣ�"+userInfo);
					break;
				}
			}
		}else if(num==2){
			System.out.println("������������");
			String name = input.next();
			for(int i=0;i<list.size();i++) {
				userInfo = (UserInfo) list.get(i);
				if(userInfo.getName().equals(name)) {
					System.out.println("��ѯ�����û����ݣ�"+userInfo);
					break;
				}
			}
		}else if(num==3) {
			System.out.println("�������Ա�");
			String sex = input.next();
			for(int i=0;i<list.size();i++) {
				userInfo = (UserInfo) list.get(i);
				if(userInfo.getSex().equals(sex)) {
					System.out.println("��ѯ�����û����ݣ�"+userInfo);
					break;
				}
			}
		}else {
			System.out.println("����������������룡");
			this.selectUserInfo();
		}
		this.show();
	}
	
	public void show() {
		System.out.println("��ִ�в�������1����� ��2��ɾ�� ��3����ѯ");
		int num = input.nextInt();
		if(num==1) {
			this.addUserInfo();
		}else if(num==2) {
			this.deleteUserInfo();
		}else if(num==3) {
			this.selectUserInfo();
		}else {
			System.out.println("����������������룡");
			this.show();
		}
	}
}
