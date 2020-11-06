package com.xb.t8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {
  public static void main(String[] args){
    HashMap<String,Student> hashMap = new HashMap<>();
    for(int i=1;i<=10;i++){
      hashMap.put(""+i,new Student("学生"+i,i));
    }
    Set set = hashMap.keySet();
    Iterator iterator = set.iterator();
    while (iterator.hasNext()){
      System.out.println(hashMap.get(iterator.next()));
    }
  }
}
