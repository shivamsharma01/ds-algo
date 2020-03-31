package bytebybyte;

import java.util.Scanner;

public class NStacks {
	int[] topOfStack;
	int[] stackData;
	int[] nextIndex;
	int nextAvailableIndex = 0;

	public NStacks(int numStacks, int capacity) {
		topOfStack = new int[numStacks];
		for (int i = 0; i < topOfStack.length; i++) {
			topOfStack[i] = -1;
		}
		stackData = new int[capacity];
		nextIndex = new int[capacity];
		for (int i = 0; i < nextIndex.length; i++) {
			nextIndex[i] = i + 1;
		}
		nextIndex[nextIndex.length - 1] = -1;
	}

	public void push(int stack, int value) {
		System.out.println("Pushing in stack " + (stack + 1) + " -> " + value);
		if (stack < 0 || stack > topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}
		if (nextAvailableIndex < 0) {
			return; // or throw error
		}
		int currentIndex = nextAvailableIndex;
		nextAvailableIndex = nextIndex[currentIndex];
		stackData[currentIndex] = value;
		nextIndex[currentIndex] = topOfStack[stack];
		topOfStack[stack] = currentIndex;
	}

	public int pop(int stack) {
		if (stack < 0 || stack > topOfStack.length || topOfStack[stack] < 0) {
			throw new IndexOutOfBoundsException();
		}
		int currentIndex = topOfStack[stack];
		int value = stackData[currentIndex];
		topOfStack[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] = nextAvailableIndex;
		nextAvailableIndex = currentIndex;
		System.out.println("Popping from stack " + (stack + 1) + " -> " + value);
		return value;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int stackCount = scan.nextInt();
		int capacity = scan.nextInt();
		NStacks stacks = new NStacks(stackCount, capacity);
		stacks.print();
		System.out.println("Pushing");
		for (int i = 1; i <= 7; i++) {
			stacks.push((int) (Math.random() * stackCount), (int) (Math.random() * 100));
			stacks.print();
		}
		System.out.println("Popping");
		for (int i = 1; i <= 4; i++) {
			try {
				stacks.pop((int) (Math.random() * stackCount));
			} catch (Exception e) {
			}
			stacks.print();
		}
		System.out.println("Pushing");
		for (int i = 1; i <= 7; i++) {
			stacks.push((int) (Math.random() * stackCount), (int) (Math.random() * 100));
			stacks.print();
		}
	}

	public void print() {
		System.out.println("nextAvailableIndex = " + nextAvailableIndex);
		System.out.print("topOfStack = {");
		for (int i = 0; i < topOfStack.length; i++) {
			System.out.print(i < topOfStack.length - 1 ? topOfStack[i] + ", " : topOfStack[i]);
		}
		System.out.println("}");
		System.out.print("nextIndex = {");
		for (int i = 0; i < nextIndex.length; i++) {
			System.out.print(i < nextIndex.length - 1 ? nextIndex[i] + ", " : nextIndex[i]);
		}
		System.out.println("}");
		System.out.print("stackData = {");
		for (int i = 0; i < stackData.length; i++) {
			System.out.print(i < stackData.length - 1 ? stackData[i] + ", " : stackData[i]);
		}
		System.out.println("}");
		System.out.println("\n===================================");
	}
}