package com.xb.phone;

public class Shouji extends Phone {

	@Override
	public void sendCall(String name) {
		System.out.println(name+"���Դ�绰");
	}
	
	@Override
	public void getCall(String name) {
		System.out.println(name+"���Խӵ绰");
	}
	
	public void net(String name) {
		System.out.println(name+"��������");
	}
}
