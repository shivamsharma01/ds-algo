package bytebybyte;

import java.util.Stack;

public class Palindromes {

	static class Node {
		public int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Node start = createLinkedList(1, 2, 3, 2, 1);
		printLinkedList(start);
		System.out.println(isPalindrome(start) ? "Is a Palindrome" : "Not a palindrome");
	}

	public static boolean isPalindrome(Node n) {
		Node runner = n;
		Node current = n;
		Stack<Integer> stack = new Stack<>();
		while (runner != null && runner.next != null) {
			stack.add(current.value);
			current = current.next;
			runner = runner.next.next;
		}

		// This case is also handled as current is at the correct location
		// 1 -> 2 -> 3 -> 3 -> 2 -> 1 -> null
		//                ^ 			  ^

		// Here current is at the middle element, therefore we move ahead 1 location
		// 1 -> 2 -> 3 -> 2 -> 1
		//           ^         ^
		if (runner != null)
			current = current.next;
		while(current != null) {
			if(stack.pop().intValue() != current.value) {
				return false;
			}
			current = current.next;
		}
		return true;
	}

	private static Node createLinkedList(int... values) {
		Node start = null;
		if (values.length == 0) {
			return start;
		}
		start = new Node(values[0]);
		Node current = start;
		for (int i = 1; i < values.length; i++) {
			current.next = new Node(values[i]);
			current = current.next;
		}
		return start;
	}

	private static void printLinkedList(Node n) {
		if (n == null) {
			return;
		}
		System.out.print(n.value + " -> ");
		printLinkedList(n.next);
	}
}
