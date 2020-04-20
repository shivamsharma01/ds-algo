package prepbytes.topic.recursion;

import java.util.Scanner;

public class CombinationOfFactors {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			printFactors(scan.nextInt(), 2, "1 ");
		}
	}

	private static void printFactors(int n, int p, String s) {
		if (n == 1) {
			System.out.println(s.trim());
			return;
		}
		for (int i = p; i <= n; i++) {
			if (n % i == 0) {
				printFactors(n / i, i, s + i + " ");
			}
		}
	}
}
