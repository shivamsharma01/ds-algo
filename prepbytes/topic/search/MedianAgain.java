package prepbytes.topic.search;

import java.util.Scanner;

public class MedianAgain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[scan.nextInt()];
		int k = scan.nextInt();
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(calculateMaxMedian(arr, k));
	}

	private static int calculateMaxMedian(int[] arr, int k) {
		int median = arr.length / 2, valDif, indexDif;
		if (arr.length == 1)
			return arr[median] + k;
		while (k != 0 && arr[median] != arr[arr.length - 1]) {
			for (int i = median; i < arr.length - 1 && k > 0; i++) {
				valDif = arr[i + 1] - arr[i];
				indexDif = i + 1 - median;
				if (indexDif <= k) {
					if (valDif * indexDif <= k) {
						k -= valDif * indexDif;
						arr[median] += valDif;
					} else {
						arr[median] += k / indexDif;
						k = 0;
					}
				} else {
					k = 0;
				}
			}
		}
		arr[median] += k / (median + 1);
		return arr[median];
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
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
