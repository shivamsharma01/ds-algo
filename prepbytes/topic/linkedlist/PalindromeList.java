package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeList {

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node root = new Node(sc.nextInt()), head = root;
			for (int i = 1; i < n; i++) {
				root.next = new Node(sc.nextInt());
				root = root.next;
			}
			System.out.println(isPalindrome(head));
		}
	}

	private static boolean isPalindrome(Node head) {
		Stack<Integer> stack = new Stack<>();
		Node cur = head, runner = head;
		while (runner.next != null && runner.next.next != null) {
			stack.add(cur.val);
			cur = cur.next;
			runner = runner.next.next;
		}
		if (runner == head) {
			cur = cur.next;
			stack.add(head.val);
		} else if (runner.next == null) {
			cur = cur.next;
		} else {
			stack.add(cur.val);
			cur = cur.next;
		}
		while (cur != null) {
			if (!stack.pop().equals(cur.val))
				return false;
			cur = cur.next;
		}
		return true;
	}

}
