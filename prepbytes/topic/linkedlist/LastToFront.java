package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class LastToFront {
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
			head = placeLastToFront(head);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static Node placeLastToFront(Node head) {
		Node cur = head, next = cur;
		while (next.next != null) {
			cur = next;
			next = next.next;
		}
		next.next = head;
		cur.next = null;
		return next;
	}

}
