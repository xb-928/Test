package com.xb.t8;

public class Enter {
  public static void main(String[] args){
    Human human = new Human();
    human.addDrance(new Drance() {
      @Override
      public void drance() {
        System.out.println("我学会了跳舞！");
      }
    });
  }
}

