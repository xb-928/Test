package com.xb.phone;

public class Enter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Zuoji zuoji = new Zuoji();
		Shouji shouji = new Shouji();
		
		zuoji.sendCall("����");
		zuoji.getCall("����");
		
		shouji.sendCall("�ֻ�");
		shouji.getCall("�ֻ�");
		shouji.net("�ֻ�");
		
	}

}
