package AnimalDemo;

public class Cat extends Animal {
  public Cat(String weight, int age) {
    super(weight, age);
  }

  @Override
  public void showInfo() {
    System.out.println("一只小猫");
  }
}
