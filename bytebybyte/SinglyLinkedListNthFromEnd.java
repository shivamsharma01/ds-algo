package bytebybyte;

import java.util.Arrays;
import java.util.List;

public class SinglyLinkedListNthFromEnd {
	public static Node createNode(int value) {
		return new Node(value);
	}

	public static Node AddNode(Node tail, int newNodeValue) {
		Node newNode = createNode(newNodeValue);
		tail.setNext(newNode);
		return newNode;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Node head = createNode(list.get(0));
		Node tail = head;
		for (int i = 1; i < list.size(); i++) {
			tail = AddNode(tail, list.get(i));
		}
		System.out.println(nThToLast(head, -1));
	}

	private static Node nThToLast(Node head, int n) {
		Node current = head;
		Node follower = head;
		for (int i = 0; i < n; i++) {
			if(current == null) {
				return null;
			}
			current = current.getNext();
		}
		while(current != null) {
			current = current.getNext();
			follower = follower.getNext();
		}
		return follower;
	}

}

class Node {
	private int value;
	private Node next;

	Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return ""+this.value;
	}
}