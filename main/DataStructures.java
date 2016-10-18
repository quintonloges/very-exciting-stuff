package main;

import LL.LinkedList;

public class DataStructures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addToFront(1);
		test.addToEnd(3);
		test.addToFront(2);
		test.addToFront(4);
		test.addToFront(5);
		test.addToEnd(6);

		//test.insert(0, 3);
		//test.remove(3);

		test.printList();
		System.out.println(test.toString());
	}

}
