package prepbytes.topic.maths;

import java.util.Scanner;

public class PrepBuddyAndOne {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			System.out.println(sum(countOnes(scan.nextInt(), scan.next())));
		}
	}

	private static int countOnes(int n, String s) {
		return n - s.replaceAll("1", "").length();
	}

	private static long sum(int n) {
		return n * (long) (n + 1) / 2;
	}
}
