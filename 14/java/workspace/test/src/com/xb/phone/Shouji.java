package com.xb.phone;

public class Shouji extends Phone {

	@Override
	public void sendCall(String name) {
		System.out.println(name+"可以打电话");
	}
	
	@Override
	public void getCall(String name) {
		System.out.println(name+"可以接电话");
	}
	
	public void net(String name) {
		System.out.println(name+"还能上网");
	}
}
