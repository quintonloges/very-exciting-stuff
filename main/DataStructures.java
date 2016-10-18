package main;

import LL.LinkedList;
import SQ.Stack;

public class DataStructures {

	public static void main(String[] args) {

		System.out.println("***********\n* Testing Linked List:\n***********\n");

		LinkedList<String> test = new LinkedList<String>();
		test.addToFront("Deez");
		test.addToEnd("Nutz");
		test.addToEnd("Are");
		test.addToEnd("Not");
		test.addToEnd("Delicious");

		test.removeFirstOccurence("Not");

		test.printList();
		System.out.println(test.toString());

		System.out.println("\n***********\n* Testing Stack:\n***********\n");
		Stack<String> testStack = new Stack<String>();
		testStack.push("Well");
		testStack.push("This");
		testStack.push("is");
		testStack.push("A");
		testStack.push("Stack");

		while(testStack.isEmpty() == false) {
			System.out.println(testStack.pop());
		}
	}

}
