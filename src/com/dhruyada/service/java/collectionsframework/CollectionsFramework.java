package com.dhruyada.service.java.collectionsframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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
		
		System.out.println("===================");
		
		//Queue
		
		Queue<Integer> queue = new PriorityQueue<>();

		queue.offer(2);
		queue.offer(8);
		queue.offer(3);
		queue.offer(1);
		queue.offer(10);

		System.out.println("Get head of the queue and remove element: " 
								+ queue.poll());

		System.out.println("Size of the queue after poll(): " 
								+ queue.size());
		
		System.out.println("peek(): " + queue.peek());
		
		System.out.println("Size of the queue after peek(): " 
								+ queue.size());
	
		//Possible usecase
		
//		class Task {
//		    String name;
//		    int priority;
//
//		    Task(String name, int priority) {
//		        this.name = name;
//		        this.priority = priority;
//		    }
//		}
//
//		// Comparator to sort tasks by priority (lower number = higher priority)
//		PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));
		
		//Map - HashMap
		
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "two");
		map.put(1, "one");
		map.put(3, "three");
		map.put(4, null);

		// ===== Get element from Map
		System.out.println("Get element from map - get(1): " + map.get(1));

		// ===== Iterate over map keys
		System.out.println("Iterating over map keys demo: ");
		for (Integer key : map.keySet()) {
			System.out.println(key);
		}

		// ===== Iterate over map entries
		System.out.println("Iterating over map entries demo: ");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Entry key: " + entry.getKey() + "\t" + "Entry value: "
					+ entry.getValue());
		}

		// ====== getOrDefault demo
		System.out.println(
				"getOrDefault method demo with key 4: " + map.getOrDefault(4, "default"));
		System.out.println(
				"getOrDefault method demo with key 5: " + map.getOrDefault(5, "default"));

		// ====== putIfAbsent demo
		map.putIfAbsent(4, "four");
		System.out
				.println("After putIfAbsent method was called for key 4: " + map.get(4));

		map.putIfAbsent(7, "seven");
		System.out
				.println("After putIfAbsent method was called for key 7: " + map.get(7));
		
	}
}
