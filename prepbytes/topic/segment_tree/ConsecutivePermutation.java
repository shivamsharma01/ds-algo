package prepbytes.topic.segment_tree;

import java.io.IOException;
import java.util.Scanner;

public class ConsecutivePermutation {
	static int n;
	static int[] arr;
	static int[] minSegment, maxSegment, sumSegment;
	static int MOD = 1000000007;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			n = sc.nextInt();
			arr = createInputArray(sc);
			createSegment(arr);
			int q = sc.nextInt();
			while (q-- > 0) {
				int qLow = sc.nextInt(), qHigh = sc.nextInt();
				int min = rangeMinQuery(0, n - 1, qLow - 1, qHigh - 1, 0);
				int max = rangeMaxQuery(0, n - 1, qLow - 1, qHigh - 1, 0);
				int sum = rangeSumQuery(0, n - 1, qLow - 1, qHigh - 1, 0);
				System.out.println(sum == sum(max, min));
			}
		}
	}

	private static int[] createInputArray(Scanner sc) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		return arr;
	}

	private static void createSegment(int[] arr) {
		int size = getSegmentSize();
		minSegment = new int[size];
		maxSegment = new int[size];
		sumSegment = new int[size];
		createSegment(arr, 0, n - 1, 0);
	}

	private static int getSegmentSize() {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		return 2 * (int) Math.pow(2, x) - 1;
	}

	private static void createSegment(int[] arr, int low, int high, int pos) {
		if (low == high) {
			minSegment[pos] = arr[low];
			maxSegment[pos] = arr[low];
			sumSegment[pos] = arr[low];
			return;
		}
		int mid = low + (high - low) / 2;
		createSegment(arr, low, mid, pos * 2 + 1);
		createSegment(arr, mid + 1, high, pos * 2 + 2);
		minSegment[pos] = Math.min(minSegment[pos * 2 + 1], minSegment[pos * 2 + 2]);
		maxSegment[pos] = Math.max(maxSegment[pos * 2 + 1], maxSegment[pos * 2 + 2]);
		sumSegment[pos] = (sumSegment[pos * 2 + 1] + sumSegment[pos * 2 + 2]) % MOD;
	}

	private static int rangeSumQuery(int low, int high, int qLow, int qHigh, int pos) {
		if (qLow > high || qHigh < low)
			return 0;
		if (qLow <= low && qHigh >= high)
			return sumSegment[pos];
		int mid = low + (high - low) / 2;
		int max1 = rangeSumQuery(low, mid, qLow, qHigh, pos * 2 + 1) % MOD,
				max2 = rangeSumQuery(mid + 1, high, qLow, qHigh, pos * 2 + 2) % MOD;
		return (max1 + max2) % MOD;
	}

	private static int rangeMinQuery(int low, int high, int qLow, int qHigh, int pos) {
		if (qLow > high || qHigh < low)
			return Integer.MAX_VALUE;
		if (qLow <= low && qHigh >= high)
			return minSegment[pos];
		int mid = low + (high - low) / 2;
		int min1 = rangeMinQuery(low, mid, qLow, qHigh, pos * 2 + 1),
				min2 = rangeMinQuery(mid + 1, high, qLow, qHigh, pos * 2 + 2);
		return Math.min(min1, min2);
	}

	private static int rangeMaxQuery(int low, int high, int qLow, int qHigh, int pos) {
		if (qLow > high || qHigh < low)
			return Integer.MIN_VALUE;
		if (qLow <= low && qHigh >= high)
			return maxSegment[pos];
		int mid = low + (high - low) / 2;
		int max1 = rangeMaxQuery(low, mid, qLow, qHigh, pos * 2 + 1),
				max2 = rangeMaxQuery(mid + 1, high, qLow, qHigh, pos * 2 + 2);
		return Math.max(max1, max2);
	}

	private static int sum(int high, int low) {
		int total = (high * (high + 1) % MOD) / 2;
		int extra = (low * (low - 1) % MOD) / 2;
		return (total - extra + MOD) % MOD;
	}
}
