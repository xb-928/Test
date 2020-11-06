package wingoop;

public class Student {
  //定义一个全局变量，接收实现了接口的对象
  private Action action;
  //给接口赋值
  public void addAction(Action action){
    this.action = action;
  }
  //调用接口方法
  public void doSome(){
    this.action.doing();
  }
}
