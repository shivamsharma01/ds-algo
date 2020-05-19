package prepbytes.marathon.linkedlist;

import java.util.Scanner;

public class Second {
	static class SinglyLinkedListNode {
		char value;
		SinglyLinkedListNode next;

		SinglyLinkedListNode(char nodeData) {
			this.value = nodeData;
			this.next = null;
		}
	}

	static SinglyLinkedListNode BinaryList(SinglyLinkedListNode head) {
		if (head == null || head.next == null)
			return head;
		SinglyLinkedListNode zero = null, one = null, link = null;
		SinglyLinkedListNode cur = null;
		int zeroCount = 0, oneCount = 0;
		while (head != null) {
			cur = head;
			head = head.next;
			cur.next = null;
			if (cur.value == '0') {
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

	public static void main(String[] args) throws InterruptedException {

	}
}
