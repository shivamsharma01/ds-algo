package prepbytes.topic.stack;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyDirectoryPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] arr = input.split("/");
		StringBuilder output = new StringBuilder(""), other = new StringBuilder("");
		Stack<String> stack = new Stack<>();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].equals("."))
				continue;
			else if (arr[i].equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
				else
					output.append("/..");
			} else {
				stack.push(arr[i]);
			}
		}
		while (!stack.isEmpty())
			other.insert(0, "/" + stack.pop());
		System.out.println(output.append(other));
	}
}
