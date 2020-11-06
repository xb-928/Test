package com.xb.t8;

import java.util.ArrayList;

public class Student {

  private String name;
  private int age;
  public Student(String name,int age){
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name+"\t"+age;
  }

  public static void main(String[] args){
    ArrayList<Student> arrayList = new ArrayList<>();
    for(int i = 0;i<10;i++){
      arrayList.add(new Student("学生"+(i+1),i+1));
      System.out.println(arrayList.get(i));
    }

  }
}
