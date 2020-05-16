package leetcode.thirty_days_challenge.may;

public class OddEvenLinkedList {
	// Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return head;
		ListNode cur = head, evenStart = null, even = null;
		even = head.next;
		evenStart = even;
		cur.next = even.next;
		cur = cur.next;
		while (cur != null && cur.next != null) {
			System.out.println(cur.val);
			even.next = cur.next;
			even = even.next;
			if (even.next != null) {
				cur.next = even.next;
				cur = cur.next;
			} else
				cur.next = null;
		}
		even.next = null;
		cur.next = evenStart;
		return head;
	}

}