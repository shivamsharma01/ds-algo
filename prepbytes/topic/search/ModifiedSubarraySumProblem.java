package prepbytes.topic.search;

import java.util.Scanner;

public class ModifiedSubarraySumProblem {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = new int[scan.nextInt()], subsetsStartingWithCount = new int[arr.length];
			long K = scan.nextLong();
			int M = scan.nextInt();

			for (int i = 0; i < arr.length; i++)
				arr[i] = scan.nextInt();

			long subsetCount = findSubsets(arr, subsetsStartingWithCount, K, M);
			if (subsetCount == 0 || K == 1)
				System.out.println(subsetCount % MOD);
			else
				System.out.println(findTotalSubsets(arr, subsetsStartingWithCount, subsetCount, K, M));
		}
	}

	private static long findTotalSubsets(int[] arr, int[] subsetsStartingWithCount, long subsetCount, long K, int M) {
		int n = arr.length;
		long span, left;
		if (arr[0] >= M || arr[n - 1] >= M || n > 1 && arr[0] + arr[n - 1] > M)
			return (K % MOD) * (subsetCount % MOD) % MOD;
		span = (int) Math.ceil((subsetsStartingWithCount[n - 1] - 1) / (double) n);
		if (K - span > 0)
			subsetCount = ((K - span) % MOD) * (subsetCount % MOD) % MOD;
		left = span * n;
		for (int i = 0; i < n; i++) {
			if (subsetsStartingWithCount[i] > (left - i))
				subsetCount = ((subsetCount % MOD) + ((left - i) % MOD)) % MOD;
			else
				subsetCount = ((subsetCount % MOD) + ((subsetsStartingWithCount[i]) % MOD)) % MOD;
		}
		span = (span - 1) * n;
		subsetCount = ((subsetCount % MOD) + ((span * (span + 1) / 2) % MOD)) % MOD;
		return (subsetCount % MOD);
	}

	private static long findSubsets(int[] input, int[] output, long K, int M) {
		long subsetCount = 0, j = 0, sum = 0;
		int n = input.length;

		// n*k might overflow, subarray can never go beyond 1000000
		if ((n * K) / n == K)
			K = n * K;
		else
			K = 10000000000000000l;
		for (int i = 0; i < n; i++) {
			if (i != 0)
				sum = sum - input[i - 1];

			for (; j < K; j++) {
				if (sum + input[(int) (j % n)] <= M)
					sum += input[(int) (j % n)];
				else
					break;
			}
			output[i] = (int) (j - i);
			subsetCount += output[i];
		}
		return subsetCount;
	}
}
