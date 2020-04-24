package prepbytes.topic.array;

import java.util.Scanner;

public class QualityFactor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long actualSumForwardedAhead = scan.nextInt();
		long moves = Math.abs(actualSumForwardedAhead);
		int num;
		for (int i = 1; i < n; i++) {
			num = scan.nextInt();
			moves += Math.abs(actualSumForwardedAhead - num);
			actualSumForwardedAhead = num;
		}
		System.out.println(moves);
	}
}
