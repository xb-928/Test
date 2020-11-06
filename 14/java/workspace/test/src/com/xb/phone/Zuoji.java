package com.xb.phone;

public class Zuoji extends Phone {


	@Override
	public void sendCall(String name) {
		System.out.println(name+"可以打电话");
	}
	
	@Override
	public void getCall(String name) {
		System.out.println(name+"可以接电话");
	}
}
