package com.dhruyada.service.java.collectionsframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionsFramework {
	public static void main(String[] args) {
		//Array List - can be non-generic as well e.g. List arr = new ArrayList();
		List<String> arrList = new ArrayList<>();
		arrList.add("arrEl1");
		arrList.add("arrEl2");
		
		System.out.println(arrList.get(0));
		
		
		//Linked List 
		List<String> linkedList = new LinkedList<>();
		linkedList.add("llfirst");
		linkedList.add("llsecond");
		
		System.out.println(linkedList.get(1));

		System.out.println("===================");
		
		//Initialization
		List<Integer> arrList2 = new ArrayList<>(Arrays.asList(1,2,3));
		arrList2.add(4);
		System.out.println(arrList2.get(1));

		System.out.println("===================");
		//Looping
		
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}

		System.out.println("===================");
		
		for(String s: arrList) {
			System.out.println(s);
		}
		
		System.out.println("===================");
		
		linkedList.clear();
		
		System.out.println(arrList);

		System.out.println("===================");
		
		System.out.println(linkedList);

		System.out.println("===================");
		
		System.out.println(arrList2);
		
		
		
	}
}
