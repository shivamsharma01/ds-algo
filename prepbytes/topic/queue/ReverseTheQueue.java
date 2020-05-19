package prepbytes.topic.queue;

import java.util.Scanner;

public class ReverseTheQueue {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int n = sc.nextInt() - 1;
			Node head = new Node(sc.nextInt()), cur = head;
			for (int i = 0; i < n; i++) {
				cur.next = new Node(sc.nextInt());
				cur = cur.next;
			}
			reverse(head);
		}
	}

	private static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();

	}

	private static void reverse(Node head) {
		Node temp = null, cur;
		while (head != null) {
			cur = head;
			head = head.next;
			cur.next = temp;
			temp = cur;
		}
		print(temp);
	}
}
