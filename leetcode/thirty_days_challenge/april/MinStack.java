package leetcode.thirty_days_challenge.april;

public class MinStack {
	private Node top;

	static class Node {
		public int val;
		public Node prev;
		public int min;

		public Node(int val) {
			this.val = val;
		}
	}

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {
		Node newNode = new Node(x);
		newNode.prev = top;
		top = newNode;
		top.min = x;
		if (top.prev != null) {
			int min = top.prev.min;
			if (min < x)
				top.min = min;
		}
	}

	public void pop() {
		if (top != null) {
			Node prev = top.prev;
			top = prev;
		}
	}

	public int top() {
		return top.val;
	}

	public int getMin() {
		return top.min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
