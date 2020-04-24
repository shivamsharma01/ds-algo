package prepbytes.topic.sorting;

import java.util.Scanner;

public class FindTheWindow {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		short t = scan.nextShort();
		while (t-- > 0) {
			int[] a = new int[scan.nextInt()];
			int[] sorted = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				a[i] = scan.nextInt();
				sorted[i] = a[i];
			}
			mergeSort(sorted, 0, sorted.length - 1);
			int left = 0, right = sorted.length - 1;
			for (int i = 0; i < sorted.length; i++, left++)
				if (a[i] != sorted[i])
					break;
			for (int i = sorted.length - 1; i >= 0; i--, right--)
				if (a[i] != sorted[i])
					break;
			System.out.println(left + " " + right);
		}
	}

	private static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(a, left, middle);
			mergeSort(a, middle + 1, right);
			merge(a, left, middle, right);
		}
	}

	private static void merge(int[] a, int left, int middle, int right) {
		int[] a1 = new int[middle - left + 2], a2 = new int[right - middle + 1];
		for (int i = 0; i < a1.length - 1; i++)
			a1[i] = a[left + i];
		for (int i = 0; i < a2.length - 1; i++)
			a2[i] = a[middle + i + 1];
		a1[a1.length - 1] = Integer.MAX_VALUE;
		a2[a2.length - 1] = Integer.MAX_VALUE;
		for (int index = left, i = 0, j = 0; index <= right; index++) {
			if (a1[i] < a2[j])
				a[index] = a1[i++];
			else
				a[index] = a2[j++];
		}
	}

}
