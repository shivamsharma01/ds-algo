package prepbytes.topic.sorting;

import java.util.Scanner;

public class SortInAUniqueWay {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		short t = scan.nextShort();
		while (t-- > 0) {
			int[] a = new int[scan.nextInt()];
			for (int i = 0; i < a.length; i++)
				a[i] = scan.nextInt();
			System.out.println(mergeSort(a, 0, a.length - 1));
		}
	}

	private static int mergeSort(int[] arr, int left, int right) {
		int i1 = 0, i2 = 0, middle;
		if (left < right) {
			middle = left + (right - left) / 2;
			i1 = mergeSort(arr, left, middle);
			i2 = mergeSort(arr, middle + 1, right);
			if (i1 == (middle - left + 1) && i2 == (right - middle))
				if (arr[middle] <= arr[middle + 1])
					return i1 + i2;
			return Math.max(i1, i2);
		}
		return 1;
	}

}
