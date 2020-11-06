package AnimalDemo;

public class Animal {
  private String weight;
  private int age;
  public void setWeight(String weight){
    this.weight = weight;
  }
  public String getWeight(){
    return weight;
  }
  public void setAge(int age){
    this.age = age;
  }
  public int getAge(){
    return age;
  }
  public Animal(String weight,int age){
    System.out.println("体重"+weight+"，年龄"+age);
  }
  public void showInfo(){
    System.out.println("一只动物");
  }
}
