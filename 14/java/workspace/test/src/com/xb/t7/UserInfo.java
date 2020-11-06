package com.xb.t7;

public class UserInfo {

	private String no,name,sex;

	public UserInfo(String no,String name,String sex) {
		this.no = no;
		this.name = name;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return no+"\t"+name+"\t"+sex;
	}
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
