package com.code.practice;

import java.util.LinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {

		LinkedList<String> linkedList = new LinkedList<String>();

		linkedList.add("Delhi");
		linkedList.add("Banglore");
		linkedList.add("Chennai");
		linkedList.add("Maharastra");
		linkedList.add("Jaipur");

		System.out.println("Before Reverse --" + linkedList);
		linkedList = reverseLinkedList(linkedList);
		System.out.println("After Reverse -- " + linkedList);

	}

	public static LinkedList<String> reverseLinkedList(LinkedList<String> linkedList) {

		LinkedList<String> revlinkedList = new LinkedList<String>();
		for (int i = linkedList.size() - 1; i >= 0; i--) {

			revlinkedList.add(linkedList.get(i));
		}

		return revlinkedList;
	}
}
