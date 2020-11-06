package com.xb.phone;

public class Enter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Zuoji zuoji = new Zuoji();
		Shouji shouji = new Shouji();
		
		zuoji.sendCall("恙字");
		zuoji.getCall("恙字");
		
		shouji.sendCall("返字");
		shouji.getCall("返字");
		shouji.net("返字");
		
	}

}
