package leetcode.thirty_days_challenge.april;

public class MiddleOfLinkedList {
	public ListNode middleNode(ListNode head) {
		ListNode runner = head;
		ListNode cur = head;
		while (runner != null && runner.next != null) {
			cur = cur.next;
			runner = runner.next.next;
		}
		return cur;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
