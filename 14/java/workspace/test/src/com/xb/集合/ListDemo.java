package com.xb.����;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ListDemo {

	public static void main(String[] args) {
		//ArrayListʵ����
		ArrayList arrayList = new ArrayList();
		arrayList.add("С��");
		arrayList.add("С��");
		arrayList.add("С��");
		arrayList.add("С��");
		arrayList.add("С��");
		System.out.println(arrayList);
		arrayList.remove("С��");
		System.out.println("Arraylist����");
		System.out.println();
		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
		
		//LinkedListʵ����
		LinkedList linkedList = new LinkedList();
		System.out.println("linkedlist����");
		linkedList.add("Сŷ");
		linkedList.add(1);
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
		
		//Set����
		HashSet hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(2);
		Iterator iterator = hashSet.iterator();
		System.out.println("HashSet����");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		for (Object obj : hashSet) {
			System.out.println(obj);
		}
		
		//Map����
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("����", "2");
		hashMap.put("����", "3");
		hashMap.put("����", "3");
		hashMap.put("��Y", "3");
		System.out.println(hashMap.get("��Y"));
		Iterator iterator2 = hashMap.values().iterator();
		Iterator iterator3 = hashMap.keySet().iterator();
		System.out.println("Hash");
		while(iterator2.hasNext()) {
			System.out.println(iterator3.next()+":"+iterator2.next());
		}
	}
}
