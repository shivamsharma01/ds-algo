package prepbytes.topic.stack;

import java.util.Scanner;

public class CompileCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int n = sc.nextInt();
			String input = sc.next();
			int length = 0, left = 0, run = 0;
			for (int i = 0; i < n; i++) {
				char c = input.charAt(i);
				if (c == '<')
					left++;
				else
					left--;
				run++;
				if (left < 0)
					break;
				if (left == 0) {
					length += run;
					run = 0;
				}
			}
			System.out.println(length);
		}
	}
}
