package prepbytes.topic.maths;

import java.util.Scanner;

public class LargeGCD {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			System.out.println(getLargeGCD(scan.nextLong(), scan.next()));
		}
	}

	private static long getLargeGCD(long n, String m) {
		long result = 0;
		for (int i = 0; i < m.length(); i++) {
			result = result * 10 + m.charAt(i) - '0';
			result = result % n;
		}
		return gcd(n, result);
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
