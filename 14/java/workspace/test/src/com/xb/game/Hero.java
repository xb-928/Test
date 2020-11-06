package com.xb.game;

public abstract class Hero {

	private String name;
	private int bloodVolume;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBloodVolume() {
		return bloodVolume;
	}

	public void setBloodVolume(int bloodVolume) {
		this.bloodVolume = bloodVolume;
	}

	public Hero(String name,int bloodVolume) {
		this.name = name;
		this.bloodVolume = bloodVolume;
	}
	
	public abstract void normalAttack();
	
	
}
