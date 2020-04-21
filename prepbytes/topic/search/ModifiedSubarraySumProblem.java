package prepbytes.topic.search;

import java.util.Scanner;

public class ModifiedSubarraySumProblem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = new int[scan.nextInt()];
			int M = scan.nextInt(), MOD = 1000000007;
			long sum = 0, K = scan.nextLong();
			int start = 0, end, subsetSum = 0, subsets;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scan.nextInt();
			}
			for (long i = 0; i < K * arr.length; i++, i = i % (arr.length - 1)) {
				if (subsetSum + arr[i] <= M) {
					subsetSum += arr[i];
				}
			}
			System.out.println(sum);
		}
	}
}
