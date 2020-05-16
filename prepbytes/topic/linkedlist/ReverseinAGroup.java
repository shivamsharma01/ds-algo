package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class ReverseinAGroup {

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
			int k = sc.nextInt();
			head = modifiedRotate(head, k);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static Node modifiedRotate(Node root, int k) {
		if (k == 0 || k == 1)
			return root;
		Node head = null, cur = null, chain = null, joiner1 = null, joiner2 = null;
		boolean isFirst = true;
		int count = k;
		while (root != null) {
			if (isFirst) {
				while (count-- > 0 && root != null) {
					if (count == k - 1) {
						joiner1 = new Node(root.val);
						cur = joiner1;
					} else
						cur = new Node(root.val);
					cur.next = chain;
					chain = cur;
					root = root.next;
				}
				isFirst = false;
				head = chain;
			} else {
				while (count-- > 0 && root != null) {
					if (count == k - 1) {
						joiner2 = new Node(root.val);
						cur = joiner2;
					} else
						cur = new Node(root.val);
					cur.next = chain;
					chain = cur;
					root = root.next;
				}
				joiner1.next = chain;
				joiner1 = joiner2;
				joiner2 = null;
			}
			count = k;
			chain = null;
		}
		return head;
	}

}
