package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class RemoveDuplicate {
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
			head = removeDuplicate(head);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static Node removeDuplicate(Node head) {
		Node cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head;
	}

}
