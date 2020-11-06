package wingoop;

public class Main {
  public static void main(String[] args){
    Student student = new Student();
    student.addAction(new Action() {
      @Override
      public void doing() {
        System.out.print("我在敲代码");
      }
    });
    student.doSome();
  }
}
