package prepbytes.topic.segment_tree;

import java.io.IOException;
import java.util.Scanner;

public class MaximumDivisor {
	static int n;
	static int[] arr;
	static int[] segment;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			n = sc.nextInt();
			arr = createInputArray(sc);
			segment = createSegment(arr);
			for (int i = 0; i < segment.length; i++)
				System.out.print(segment[i] + " ");
			System.out.println();
			int q = sc.nextInt();
			while (q-- > 0) {
				int qLow = sc.nextInt(), qHigh = sc.nextInt();
				System.out.println(rangeMinQuery(segment, 0, n - 1, qLow - 1, qHigh - 1, 0));
			}
		}
	}

	private static int[] createInputArray(Scanner sc) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		return arr;
	}

	private static int[] createSegment(int[] arr) {
		int[] segment = new int[getSegmentSize()];
		createSegment(segment, arr, 0, n - 1, 0);
		return segment;
	}

	private static int getSegmentSize() {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		return 2 * (int) Math.pow(2, x) - 1;
	}

	private static void createSegment(int[] segment, int[] arr, int low, int high, int pos) {
		if (low == high) {
			segment[pos] = arr[low];
			return;
		}
		int mid = low + (high - low) / 2;
		createSegment(segment, arr, low, mid, pos * 2 + 1);
		createSegment(segment, arr, mid + 1, high, pos * 2 + 2);
		segment[pos] = gcd(segment[pos * 2 + 1], segment[pos * 2 + 2]);
	}

	private static int rangeMinQuery(int[] segment, int low, int high, int qLow, int qHigh, int pos) {
		if (qLow > high || qHigh < low)
			return 0;
		if (qLow <= low && qHigh >= high)
			return segment[pos];
		int mid = low + (high - low) / 2;
		int num1 = rangeMinQuery(segment, low, mid, qLow, qHigh, pos * 2 + 1),
				num2 = rangeMinQuery(segment, mid + 1, high, qLow, qHigh, pos * 2 + 2);
		return gcd(num1, num2);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
