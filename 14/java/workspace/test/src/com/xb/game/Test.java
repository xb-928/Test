package com.xb.game;

public class Test {

	public static void main(String[] args) {

		Mage mage = new Mage("ÍõÕÑ¾ı", 3000);
		mage.normalAttack();
		mage.useSkill();
		
		SuperSoldier superSoldier = new SuperSoldier(10000);
		superSoldier.normalAttack("¹¬±¾");
	}

}
