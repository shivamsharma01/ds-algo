package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class RotateDoublyList {

	static class Node {
		int val;
		Node next;
		Node prev;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt(), k = sc.nextInt();
			Node root = new Node(sc.nextInt()), head = root;
			for (int i = 1; i < n; i++) {
				root.next = new Node(sc.nextInt());
				root.next.prev = root;
				root = root.next;
			}
			head = rotateList(head, k % n);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static Node rotateList(Node root, int k) {
		Node head = root, prev = null;
		while (k-- > 0) {
			prev = root;
			root = root.next;
		}
		if (prev != null) {
			Node temp = head;
			head = prev.next;
			prev.next = null;
			prev = head;
			while (prev.next != null)
				prev = prev.next;
			prev.next = temp;
		}
		return head;
	}

}
