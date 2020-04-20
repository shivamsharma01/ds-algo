package prepbytes.topic.maths;

import java.util.Scanner;

public class SquareBread {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			System.out.println(maxSquareBread(scan.nextInt(), scan.nextInt()));
		}
	}

	private static int maxSquareBread(int l, int b) {
		int gcd = gcd(Math.max(l, b), Math.min(l, b));
		return (l / gcd) * (b / gcd);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
