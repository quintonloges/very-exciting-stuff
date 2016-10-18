package SQ;

import LL.LinkedList;

public class Stack<T extends Comparable<T>> {
	private LinkedList<T> myList;
	private int numElements;

	public Stack() {
		myList = new LinkedList<T>();
		numElements = 0;
	}

	public void push(T value) {
		numElements++;
		myList.addToFront(value);
	}

	public T pop() {
		if(numElements == 0) return null;
		numElements--;
		T ret = myList.get(0);
		myList.remove(0);
		return ret;
	}

	public boolean isEmpty() {
		return (numElements == 0);
	}
}
