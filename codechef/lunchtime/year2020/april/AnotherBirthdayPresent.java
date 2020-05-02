package codechef.lunchtime.year2020.april;

import java.util.Scanner;

/*
 * https://www.codechef.com/problems/SHUFFLE
 */
public class AnotherBirthdayPresent {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scan = new Scanner(System.in);
		byte t = 0;
		if (scan.hasNextByte())
			t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = null, sorted = null;
			if (scan.hasNextInt())
				arr = new int[scan.nextInt()];
			sorted = new int[arr.length];
			int k = 0;
			if (scan.hasNextInt())
				k = scan.nextInt();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scan.nextInt();
				sorted[i] = arr[i];
			}
			mergeSort(sorted, 0, sorted.length - 1);
			String output = "yes";
			outer: for (int i = 0; i < sorted.length; i++) {
				if (sorted[i] == arr[i])
					continue;
				for (int j = i % k; j < sorted.length; j += k) {
					if (arr[j] == sorted[i])
						continue outer;
				}
				output = "no";
				break;
			}
			System.out.println(output);
		}
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	private static void merge(int[] arr, int left, int middle, int right) {
		int[] t1 = new int[middle - left + 2];
		int[] t2 = new int[right - middle + 1];
		for (int i = 0; i <= middle - left; i++)
			t1[i] = arr[left + i];
		for (int i = 0; i < right - middle; i++)
			t2[i] = arr[middle + i + 1];
		t1[t1.length - 1] = Integer.MAX_VALUE;
		t2[t2.length - 1] = Integer.MAX_VALUE;
		int i1 = 0, i2 = 0;
		for (int i = left; i <= right; i++) {
			if (t1[i1] < t2[i2])
				arr[i] = t1[i1++];
			else
				arr[i] = t2[i2++];
		}
	}

}
