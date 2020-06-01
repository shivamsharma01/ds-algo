package leetcode.problems.easy;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class ConvertBinaryNumberInALinkedListToInteger {

	// Definition for singly-linked list.
	static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
	//	System.out.println(new ConvertBinaryNumberInALinkedListToInteger().getDecimalValue([1,0,1])); // 5
	}

	public int getDecimalValue(ListNode head) {
        int num = 0;
        while(head != null) {
            if(head.val == 1)
                num = num*2 + 1;
            else
                num *= 2;
            head = head.next;
        }
        return num;
    }

}
