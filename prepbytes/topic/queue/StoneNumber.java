package prepbytes.topic.queue;

import java.util.Scanner;

public class StoneNumber {
	static class Node {
		byte data;
		Node next;

		Node(byte data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			Node head = new Node(sc.nextByte()), cur;
			for (byte i = (byte) (head.data - 1); i > 0; i--) {
				cur = new Node(i);
				cur.next = head;
				head = cur;
			}
			System.out.println(stoneNumber(head));
		}
	}

	private static byte stoneNumber(Node head) {
		Node stone = null, queue, cur;
		while (head != null) {
			stone = head;
			head = head.next;
			stone.next = null;
			if (head != null) {
				head = head.next;
				queue = null;
				while (head != null) {
					cur = head;
					head = head.next;
					cur.next = queue;
					queue = cur;
				}
				head = stone;
				while (queue != null) {
					cur = queue;
					queue = queue.next;
					cur.next = head;
					head = cur;
				}
			}
		}
		return stone.data;
	}

}
