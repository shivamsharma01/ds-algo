package general.sort;

import java.util.Arrays;

/*
 * O(n) + O(k) where k is max element
 * stable algo
 */
public class CoutingSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 3, 2, 1, 9, 8, 7, 6 };
		int[] out = new int[arr.length];
		countingSort(arr, out, Arrays.stream(arr).max().getAsInt());
		for (int i : out) {
			System.out.print(i + "\t");
		}
	}

	private static void countingSort(int[] arr, int[] out, int k) {
		int[] count = new int[k + 1];
		for (int i : arr)
			count[i] += 1;
		for (int i = 1; i <= k; i++)
			count[i] += count[i - 1];
		for (int i = arr.length - 1; i >= 0; i--)
			out[--count[arr[i]]] = arr[i];
	}

}
