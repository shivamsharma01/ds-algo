package prepbytes.marathon.stackAndQueue;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PlayWithBrackets {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		sc.nextLine();
		while (t-- > 0) {
			char[] input = sc.nextLine().toCharArray();
			if (isValid(input))
				System.out.println("Valid");
			else
				System.out.println("Not Valid");
		}
	}

	private static boolean isValid(char[] input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input) {
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				else {
					char pop = stack.pop();
					if (c == ')' && pop != '(')
						return false;
					else if (c == ']' && pop != '[')
						return false;
					else if (c == '}' && pop != '{')
						return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
