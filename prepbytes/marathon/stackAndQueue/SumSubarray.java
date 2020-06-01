package prepbytes.marathon.stackAndQueue;

import java.io.IOException;
import java.util.Scanner;

public class SumSubarray {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), k = scan.nextInt(), prev = -1, span = 0, minSpan = Integer.MAX_VALUE, sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int j = prev == -1 ? i : prev;
			while (j < n && sum < k) {
				sum += arr[j++];
			}
			if (sum < k) {
				break;
			}
			if (sum >= k) {
				sum -= arr[j - 1];
				span = j - i;
				prev = j - 1;
				if (span < minSpan)
					minSpan = span;
			}
			if (minSpan == 1)
				break;
			sum -= arr[i];
		}
		System.out.println(minSpan);
	}
}
