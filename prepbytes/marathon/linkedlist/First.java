package prepbytes.marathon.linkedlist;

import java.util.Scanner;

public class First {
	static class SinglyLinkedListNode {
		char data;
		SinglyLinkedListNode next;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[sc.nextInt()];
		}
	}

	static SinglyLinkedListNode BinaryList(SinglyLinkedListNode head) {
		if (head == null || head.next == null)
			return head;
		SinglyLinkedListNode zero = null, one = null, cur = null, link = null;
		int zeroCount = 0, oneCount = 0;
		while (head != null) {
			cur = head;
			head = head.next;
			cur.next = null;
			if (cur.data == '0') {
				cur.next = zero;
				zero = cur;
				zeroCount++;
			} else {
				cur.next = one;
				one = cur;
				oneCount++;
			}
		}
		if (zero == null || one == null || oneCount > zeroCount || zeroCount - oneCount > 1)
			return null;
		while (zero != null && one != null) {
			cur = zero;
			zero = zero.next;
			cur.next = null;
			if (head == null) {
				link = cur;
				head = link;
			} else {
				head.next = cur;
				head = head.next;
			}
			cur = one;
			one = one.next;
			cur.next = null;
			head.next = cur;
			head = head.next;
		}
		if (zero != null)
			head.next = zero;
		head = head.next;
		head.next = null;
		return link;
	}

}
