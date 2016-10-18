package LL;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	public T value;
	public Node<T> next;
	public Node<T> prev;

	public Node(T value, Node<T> next, Node<T> prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	public String toString() {
		return value.toString();
	}

	@Override
	public int compareTo(Node<T> o) {
		return (this.value.compareTo(o.value));
	}
}