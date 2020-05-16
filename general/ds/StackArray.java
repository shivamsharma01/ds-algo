package general.ds;

public class StackArray {
	public static void main(String[] args) {
		StackArray s = new StackArray(5);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
	}

	int top = -1;
	final int max;
	int[] stack;

	public StackArray() {
		this.max = 1000;
		stack = new int[max];
	}

	public StackArray(int max) {
		this.max = max;
		stack = new int[max];
	}

	boolean isFull() {
		return top == max - 1;
	}

	boolean push(int x) {
		if (!isFull()) {
			this.stack[++top] = x;
			return true;
		}
		System.out.println("Stack is Full");
		return false;
	}

	int pop() {
		if (top != -1)
			return stack[top--];
		System.out.println("Stack is Empty");
		return -1;
	}
}
