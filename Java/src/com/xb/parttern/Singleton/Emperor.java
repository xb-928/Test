package com.xb.parttern.Singleton;

public class Emperor {
  private static Emperor emperor = new Emperor();
  private Emperor() {

  }
  public static Emperor getInstance() {
    return emperor;
  }
}
