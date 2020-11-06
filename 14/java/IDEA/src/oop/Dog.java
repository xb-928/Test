package oop;

public class Dog extends Animal implements Sing {
  @Override
  public void init() {
    System.out.println("一只小狗");
  }

  public void showInfo(){
    System.out.println("个人信息");
  }

  public void showInfo(String name){
    System.out.println("我的名字是"+name);
  }

  public void showInfo(String name,int age){
    System.out.println("我的名字是"+name+"，我的年龄是"+age+"岁!");
  }

  @Override
  public void singing() {
    System.out.println("这只够学会了唱歌！");
  }
}
