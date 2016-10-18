package LL;

public class LinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private Node<T> tail;
	private int nodeCount;

	public LinkedList() {
		nodeCount = 0;
		head = null;
		tail = null;
	}

	public void initializeList(T val) {
		head = new Node<T>(val, null, null);
		tail = head;
		nodeCount++;
	}

	public void addToFront(T val) {
		if(nodeCount == 0) {
			initializeList(val);
			return;
		}

		Node<T> newHead = new Node<T>(val, head, null);
		newHead.next.prev = newHead;

		head = newHead;

		nodeCount++;
	}

	public void addToEnd(T val) {
		if(nodeCount == 0) {
			initializeList(val);
			return;
		}

		Node<T> newTail = new Node<T>(val, null, tail);
		newTail.prev.next = newTail;

		tail = newTail;

		nodeCount++;
	}

	public void insert(int index, T val) {
		if(index > nodeCount) return;
		Node<T> nodeToGoAfterNewNode = findNodeAtIndex(index);
		Node<T> nodeToGoBeforeNewNode;
		if(nodeToGoAfterNewNode != null) {
			nodeToGoBeforeNewNode = nodeToGoAfterNewNode.prev;
		} else {
			nodeToGoBeforeNewNode = tail;
		}

		Node<T> newNode = new Node<T>(val, nodeToGoAfterNewNode, nodeToGoBeforeNewNode);
		if(nodeToGoBeforeNewNode != null) nodeToGoBeforeNewNode.next = newNode;
		if(nodeToGoAfterNewNode != null) nodeToGoAfterNewNode.prev = newNode;

		if(index == 0) head = newNode;
		if(index == nodeCount) tail = newNode;
		nodeCount ++;
	}

	public T get(int index) {
		Node<T> retNode = findNodeAtIndex(index);
		if(retNode == null) return null;
		return retNode.value;
	}

	public boolean removeFirstOccurence(T val) {
		Node<T> nodeToDelete = findFirstNodeOccurence(head, val);
		if(nodeToDelete == null) return false;

		deleteNode(nodeToDelete);
		return true;
	}

	public boolean remove(int index) {
		Node<T> nodeToDelete = findNodeAtIndex(index);
		if(nodeToDelete == null) return false;
		deleteNode(nodeToDelete);
		return true;
	}

	public void printList() {
		Node<T> curNode = head;
		for(;;) {
			if(curNode == null) break;
			System.out.println(curNode.value.toString());
			curNode = curNode.next;
		}
	}

	public String toString() {
		String ret = "";
		Node<T> curNode = head;
		if(curNode != null) {
			ret += curNode.toString();
			curNode = curNode.next;
		}
		for(;;) {
			if(curNode == null) break;
			ret += ", " + curNode.toString();
			curNode = curNode.next;
		}
		return ret;
	}

	private Node<T> findNodeAtIndex(int index) {
		if(index > nodeCount - 1 || nodeCount == 0) return null;
		Node<T> nodeToReturn = head;
		for(int i = 0; i < index; i++) {
			nodeToReturn = nodeToReturn.next;
		}
		return nodeToReturn;
	}

	private void deleteNode(Node<T> nodeToDelete) {
		Node<T> nodeThatComesBefore, nodeThatComesAfter;
		nodeThatComesBefore = nodeToDelete.prev;
		nodeThatComesAfter = nodeToDelete.next;

		if(nodeThatComesBefore != null) nodeThatComesBefore.next = nodeThatComesAfter;
		if(nodeThatComesAfter != null) nodeThatComesAfter.prev = nodeThatComesBefore;

		if(head == nodeToDelete) {
			head = nodeToDelete.next;
		}
		if(tail == nodeToDelete) {
			tail = nodeToDelete.prev;
		}

		nodeCount--;
	}

	private Node<T> findFirstNodeOccurence(Node<T> startNode, T val) {
		if(startNode == null) return null;
		if(startNode.value == val) {
			return startNode;
		} else {
			return findFirstNodeOccurence(startNode.next, val);
		}
	}
}
