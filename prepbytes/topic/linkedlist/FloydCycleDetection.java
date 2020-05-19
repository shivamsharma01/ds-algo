package prepbytes.topic.linkedlist;

import java.util.Scanner;

public class FloydCycleDetection {
	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node head = new Node(sc.nextInt()), cur = head;
		n--;
		while (n-- > 0) {
			cur.next = new Node(sc.nextInt());
			cur = cur.next;
		}
		if (isCycle(head))
			System.out.println("Cycle Detected");
		else
			System.out.println("No Cycle Detected");
		// create a cycle
		head.next.next.next.next = head.next.next.next;
		if (isCycle(head))
			System.out.println("Cycle Detected");
		else
			System.out.println("No Cycle Detected");
	}

	private static boolean isCycle(Node head) {
		Node slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
