package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class EvenAndOddList {

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
			head = evenAndOddList(head);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static Node evenAndOddList(Node root) {
		Node head = root, even = null, eHead = null, odd = null, oHead = null;
		while (root != null) {
			if (root.val % 2 != 0) {
				if (oHead != null) {
					odd.next = new Node(root.val);
					odd = odd.next;
				} else {
					oHead = new Node(root.val);
					odd = oHead;
				}
			} else {
				eHead = new Node(root.val);
				eHead.next = even;
				even = eHead;
			}
			root = root.next;
		}
		if (odd != null)
			odd.next = eHead;
		return oHead != null ? oHead : eHead;
	}

}
