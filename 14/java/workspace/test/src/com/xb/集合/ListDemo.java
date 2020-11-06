package com.xb.集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ListDemo {

	public static void main(String[] args) {
		//ArrayList实现类
		ArrayList arrayList = new ArrayList();
		arrayList.add("小李");
		arrayList.add("小王");
		arrayList.add("小红");
		arrayList.add("小龙");
		arrayList.add("小宇");
		System.out.println(arrayList);
		arrayList.remove("小李");
		System.out.println("Arraylist遍历");
		System.out.println();
		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
		
		//LinkedList实现类
		LinkedList linkedList = new LinkedList();
		System.out.println("linkedlist遍历");
		linkedList.add("小欧");
		linkedList.add(1);
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
		
		//Set集合
		HashSet hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(2);
		Iterator iterator = hashSet.iterator();
		System.out.println("HashSet遍历");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		for (Object obj : hashSet) {
			System.out.println(obj);
		}
		
		//Map集合
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("老王", "2");
		hashMap.put("老李", "3");
		hashMap.put("老王", "3");
		hashMap.put("老Y", "3");
		System.out.println(hashMap.get("老Y"));
		Iterator iterator2 = hashMap.values().iterator();
		Iterator iterator3 = hashMap.keySet().iterator();
		System.out.println("Hash");
		while(iterator2.hasNext()) {
			System.out.println(iterator3.next()+":"+iterator2.next());
		}
	}
}
