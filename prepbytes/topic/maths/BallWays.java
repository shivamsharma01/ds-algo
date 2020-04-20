package prepbytes.topic.maths;

import java.util.Scanner;

public class BallWays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			System.out.println(getWaysToChoose(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}
	}

	private static long getWaysToChoose(int B, int G, int X, int Y) {
		return waysToChoose(B, X) * waysToChoose(G, Y);
	}

	private static long waysToChoose(int n, int r) {
		if (n == 1)
			return 1;
		if (r > n - r)
			r = n - r;
		long num = n;
		for (int i = n - 1; i >= (n - r + 1); i--) {
			num *= i;
		}
		long deno = r;
		for (int i = r - 1; i >= 2; i--) {
			deno *= i;
		}
		return num / deno;
	}

}
