package prepbytes.topic.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class EvaluateTheExpression {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a, b;
		sc.nextLine();
		String[] input = sc.nextLine().split(" ");
		if (n == 1)
			System.out.println(input[0]);
		else {
			String cur;
			Stack<Integer> stack = new Stack<>();
			stack.push(Integer.parseInt(input[0]));
			stack.push(Integer.parseInt(input[1]));
			for (int i = 2; i < n; i++) {
				cur = input[i];
				if (cur.matches("[0-9]{1,}"))
					stack.push(Integer.parseInt(cur));
				else {
					b = stack.pop();
					a = stack.pop();
					switch (cur) {
					case "/":
						stack.push(a / b);
						break;
					case "*":
						stack.push(a * b);
						break;
					case "+":
						stack.push(a + b);
						break;
					case "-":
						stack.push(a - b);
						break;
					}
				}
			}
			System.out.println(stack.pop());
		}
	}

}
