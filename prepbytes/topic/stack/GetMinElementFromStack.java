package prepbytes.topic.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GetMinElementFromStack {
	static Stack<Node> stack = new Stack<>();
	static int min = Integer.MAX_VALUE;
	static int top = -1;

	static class Node {
		int val;
		int min;

		public Node(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}

	private static void push(int x) {
		if (min > x)
			min = x;
		Node n = new Node(x, min);
		stack.push(n);
		top = x;
	}

	private static int pop() {
		int val = -1;
		if (!stack.empty()) {
			val = stack.pop().val;
			min = stack.empty() ? Integer.MAX_VALUE : stack.peek().min;
			top = stack.empty() ? -1 : stack.peek().val;
		}
		return val;
	}

	private static int top() {
		return top;
	}

	private static int getMin() {
		return stack.isEmpty() ? -1 : min;
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		sc.nextLine();
		while (Q-- > 0) {
			String[] query = sc.nextLine().split(" ");
			switch (query[0]) {
			case "1":
				push(Integer.parseInt(query[1]));
				break;
			case "2":
				int val = pop();
				if (val == -1)
					System.out.println(val);
				break;
			case "3":
				System.out.println(top());
				break;
			case "4":
				System.out.println(getMin());
				break;
			}
		}
	}

}
