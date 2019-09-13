package com.kafka.message.kafka;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.code.practice.ReverseLinkedList;

public class TestReverseLinkedList {

	@Test
	public void reverseLinkedList() {
		LinkedList<String> revlinkedList = new LinkedList<String>();
		revlinkedList.add("Delhi");
		revlinkedList.add("Banglore");
		revlinkedList.add("Chennai");
		revlinkedList.add("Maharastra");
		revlinkedList.add("Jaipur");
		LinkedList<String> linkedList = ReverseLinkedList.reverseLinkedList(revlinkedList);
		
		Assert.assertNotEquals(linkedList, revlinkedList);
	}

}
