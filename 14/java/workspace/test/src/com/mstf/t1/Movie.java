package com.mstf.t1;

public class Movie {

	private String name;
	private String type;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Movie(String name, String type, int price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	public void show() {
		System.out.println("电影名称："+getName()+"\t电影类型："+getType()+"\t电影价格："+getPrice());
	}
	
}
