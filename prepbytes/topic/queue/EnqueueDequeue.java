package prepbytes.topic.queue;

import java.util.Scanner;

public class EnqueueDequeue {
	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() - 1;
		Node head = new Node(sc.nextInt()), cur = head;
		for (int i = 0; i < n; i++) {
			print(head);
			cur.next = new Node(sc.nextInt());
			cur = cur.next;
		}
		while (head != null) {
			print(head);
			head = head.next;
		}

	}

	private static void print(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

}
