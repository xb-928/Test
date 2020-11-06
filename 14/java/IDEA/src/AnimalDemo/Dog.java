package AnimalDemo;

public class Dog extends Animal {
  public Dog(String weight, int age) {
    super(weight, age);
  }

  @Override
  public void showInfo() {
    System.out.println("一只小狗");
  }
}
