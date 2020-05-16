package prepbytes.topic.stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String output = "";
		String[] arr = input.split(" ");
		Stack<String> stack = new Stack<>();
		for (String s : arr) {
			if (s.matches("[0-9]{1,}")) {
				output += (s + " ");
			} else {
				if (!stack.isEmpty()) {
					while (!stack.isEmpty()) {
						String top = stack.peek();
						int a = precedence(top);
						int b = precedence(s);
						if (a < b) {
							output += (stack.pop() + " ");
						} else if (b < a) {
							break;
						} else {
							if (s.equals("^") || s.equals("(")) {
								break;
							} else {
								output += (stack.pop() + " ");
							}
						}
					}
					stack.push(s);
				} else {
					stack.push(s);
				}
			}
		}
		while (!stack.isEmpty())
			output += (stack.pop() + " ");
		System.out.println(output);
	}

	private static int precedence(String operator) {
		switch (operator) {
		case "(":
			return 0;
		case "^":
			return 1;
		case "/":
			return 2;
		case "*":
			return 3;
		case "+":
			return 5;
		case "-":
			return 5;
		case ")":
			return 6;
		}
		return -1;
	}
}
