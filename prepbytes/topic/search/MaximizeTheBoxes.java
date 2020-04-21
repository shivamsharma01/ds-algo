package prepbytes.topic.search;

import java.util.Scanner;

public class MaximizeTheBoxes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt(), a, b, c;
		while (q-- > 0) {
			a = scan.nextInt();
			b = scan.nextInt();
			c = scan.nextInt();
			System.out.println(getMaxBox(a, b, c));
		}
	}

	private static int getMaxBox(int a, int b, int c) {
		if (a == 0 || b == 0)
			return 0;
		if (c != 0) {
			if (c <= a && c <= b)
				return c + getMaxBox(a - c, b - c, c - c);
			else if (c <= a)
				return b;
			else if (c <= b)
				return a;
			else
				return Math.min(a, b);
		} else {
			if (a < b) {
				if (b >= 2 * a)
					return a;
				else {
					return (b - a) + getMaxBox(a - (b - a), b - 2 * (b - a), c);
				}
			} else if (b < a) {
				if (a >= 2 * b)
					return b;
				else
					return (a - b) + getMaxBox(a - 2 * (a - b), b - (a - b), c);
			} else {
				return (a + b) / 3;
			}
		}
	}

}
