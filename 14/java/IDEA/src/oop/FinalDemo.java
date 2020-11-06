package oop;

public final class FinalDemo {
  final String name = "小熊";
  public final void init(){
    System.out.println(name);
  }
  public static void main(String[] args){
    FinalDemo finalDemo = new FinalDemo();
    finalDemo.init();
  }
}
