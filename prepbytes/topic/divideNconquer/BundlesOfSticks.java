package prepbytes.topic.divideNconquer;

import java.util.Arrays;
import java.util.Scanner;

public class BundlesOfSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		long k = sc.nextInt();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max)
				max = arr[i];
		}
		Arrays.sort(arr);
		System.out.println(maxLength(arr, k, max));
	}

	private static int maxLength(int[] arr, long k, int right) {
		int left = 0, middle = 0;
		long answer = 0;
		while (left < right) {
			middle = left + (right - left) / 2;
			answer = numCandles(arr, k, middle);
			if (answer >= k) {
				answer = numCandles(arr, k, middle + 1);
				if (answer < k)
					return middle;
				left = middle + 1;
			} else {
				answer = numCandles(arr, k, middle - 1);
				if (answer >= k)
					return middle - 1;
				right = middle - 1;
			}
		}
		return middle;
	}

	private static long numCandles(int[] arr, long k, int length) {
		long candles = 0;
		if (length == 0)
			return candles;
		for (int i = arr.length - 1; i >= 0 && arr[i] / length != 0; i--)
			candles += arr[i] / length;
		return candles;
	}

}