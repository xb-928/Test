package com.xb.game;

public class Mage extends Hero implements Skill {

	public Mage(String name, int bloodVolume) {
		super(name, bloodVolume);
	}

	@Override
	public void normalAttack() {
		System.out.println(this.getName()+"使用普通攻击");
	}
	
	@Override
	public void useSkill() {
		System.out.println(this.getName()+"使用技能攻击");
	}

	
}
