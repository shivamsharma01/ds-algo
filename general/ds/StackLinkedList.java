package general.ds;

public class StackLinkedList {
	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	Node head = null;

	public static void main(String[] args) {
		StackLinkedList s = new StackLinkedList();
		System.out.println(s.pop());
		s.push(2);
		System.out.println(s.pop());
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
//		s.push(3);
//		s.push(4);
	}

	void push(int x) {
		Node n = new Node(x);
		if (head != null) {
			n.next = head;
			head = n;
		} else
			head = n;
	}

	int pop() {
		if (head == null)
			return -1;
		else {
			int val = head.val;
			head = head.next;
			return val;
		}
	}

}
