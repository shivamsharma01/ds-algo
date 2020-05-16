package prepbytes.topic.stack;

import java.util.Scanner;
import java.util.Stack;

public class MassOfMolecules {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		String a;
		int x, y, totalMass = 0;
		Stack<String> stack = new Stack<>();
		byte[] val = new byte[26];
		val['C' - 'A'] = 12;
		val['H' - 'A'] = 1;
		val['O' - 'A'] = 16;
		for (char c : input) {
			if (c == '(')
				stack.push("" + c);
			else if (c == 'C' || c == 'H' || c == 'O')
				stack.push("" + val[c - 'A']);
			else if (c - '0' > 0 && c - '0' < 10)
				stack.push("" + (Integer.parseInt(stack.pop()) * (c - '0')));
			else {
				while (true) {
					a = stack.pop();
					if (a.equals("("))
						break;
					else {
						x = Integer.parseInt(a);
						a = stack.pop();
						if (a.equals("(")) {
							stack.push("" + x);
							break;
						} else {
							y = Integer.parseInt(a);
							stack.push("" + (x + y));
						}
					}
				}
			}
		}
		while (!stack.isEmpty())
			totalMass += Integer.parseInt(stack.pop());
		System.out.println(totalMass);
	}
}
