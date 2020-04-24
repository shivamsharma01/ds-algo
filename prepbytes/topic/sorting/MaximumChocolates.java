package prepbytes.topic.sorting;

import java.io.IOException;
import java.util.Scanner;

public class MaximumChocolates {
	public static void main(String args[]) throws IOException {

		// write your code here
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			long[] arr = new long[scan.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = scan.nextLong();
			insertionSort(arr);

			long sum = 0;
			int high = arr.length - 1;
			while (high >= 0) {
				sum += arr[high];
				high -= 2;
			}
			System.out.println(sum);
		}
	}

	private static void insertionSort(long[] arr) {
		long element;
		int j;
		for (int i = 1; i < arr.length; i++) {
			element = arr[i];
			j = i;
			while (j > 0 && arr[j - 1] > element)
				arr[j] = arr[--j];
			arr[j] = element;
		}
	}
}
