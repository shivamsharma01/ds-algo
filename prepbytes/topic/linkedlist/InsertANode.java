package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class InsertANode {
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
			Node root = null, head;
			if (n > 0)
				root = new Node(sc.nextInt());
			head = root;
			for (int i = 1; i < n; i++) {
				root.next = new Node(sc.nextInt());
				root = root.next;
			}
			Node element = new Node(sc.nextInt());
			head = insertNode(head, element);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static Node insertNode(Node head, Node node) {
		if (head == null || head.val >= node.val) {
			node.next = head;
			return node;
		}
		if (head.next == null) {
			if (node.val <= head.val) {
				node.next = head;
				return node;
			} else {
				head.next = node;
				return head;
			}
		}
		Node cur = head, prev = null;
		while (cur.next != null) {
			prev = cur;
			cur = cur.next;
			if (cur.val >= node.val) {
				prev.next = node;
				node.next = cur;
				node = null;
				break;
			}
		}
		if (node != null)
			cur.next = node;
		return head;
	}
}
