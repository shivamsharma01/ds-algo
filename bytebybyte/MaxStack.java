package bytebybyte;

public class MaxStack {
	private class Node {
		private int value;
		private Node next;
		private Node oldMax;

		Node(int val) {
			this.value = val;
		}
	}

	private Node stack;
	private Node max;

	public void push(int n) {
		Node node = new Node(n);
		if (stack == null) {
			stack = node;
			max = node;
		} else {
			node.next = stack;
			stack = node;
		}
		if (max == null || max.value < node.value) {
			node.oldMax = max;
			max = node;
		}
	}

	public int pop() {
		if (stack == null) {
			throw new NullPointerException();
		}
		Node node = stack;
		stack = node.next;
		if (node.oldMax != null) {
			max = stack.oldMax;
		}
		return node.value;
	}

	public int max() {
		if (max == null) {
			throw new NullPointerException();
		}
		return max.value;
	}

}
