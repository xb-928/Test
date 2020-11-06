package com.xb.game;

public class Soldier {

	private int bloodVolume;
	
	public Soldier(int bloodVolume) {
		this.bloodVolume = bloodVolume;
	}

	public int getBloodVolume() {
		return bloodVolume;
	}

	public void setBloodVolume(int bloodVolume) {
		this.bloodVolume = bloodVolume;
	}


	public void normalAttack(String name) {
		System.out.println(name+"Ê¹ÓÃÆÕÍ¨¹¥»÷");
	}
}
