package com.mstf.string;

public class StringDemo {

	public static void main(String[] args) {
		String a = "123";
		StringBuffer b = new StringBuffer();
		b.append(a).append(false).append(55).append(2.3);
		b.reverse();
		b.setCharAt(1, '0');
		System.out.println(b);
	}
}
