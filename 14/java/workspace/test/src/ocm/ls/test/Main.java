package ocm.ls.test;

public class Main {
	String sg;
	double zl;
	double jg=0;
	double sj;
	double gw;
	public void main() {
		if (sg.equals("ƻ��")) {
			 jg=2.20*zl;
		}else if (sg.equals("����")) {
			 jg=2.0*zl;
		}else if (sg.equals("����")) {
			 jg=1.8*zl;
		}else if (sg.equals("�㽶")) {
			 jg=1.6*zl;
		}else {
			
		
		}	
		 if(jg==0) {
			System.out.println("�޴�ˮ��");
		}
		 else if (sj>=jg) {
			gw=sj-jg;
			System.out.println(zl+"��"+sg+jg+"Ԫ�����㣺"+gw+"Ԫ");
		}
	
		else  {
			System.out.println("�������");
		}
	}
	
}
