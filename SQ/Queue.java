package SQ;

import LL.LinkedList;

public class Queue<T extends Comparable<T>> {
	private LinkedList<T> myList;
	private int numElements;

	public Queue() {
		myList = new LinkedList<T>();
		numElements = 0;
	}

	public void Enqueue(T value) {
		numElements++;
		myList.addToEnd(value);
	}

	public T Dequeue() {
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
