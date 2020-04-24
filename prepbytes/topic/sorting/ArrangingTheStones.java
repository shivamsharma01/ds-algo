package prepbytes.topic.sorting;

import java.util.Scanner;

public class ArrangingTheStones {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int n = scan.nextInt(), first = (int) Math.ceil(n / (double) 2);
			int[] arr = new int[n], tinaArr = new int[first + 1], rahulArr = new int[n - first + 1];
			for (int i = 0; i <= first - 1; i++)
				tinaArr[i] = scan.nextInt();
			tinaArr[first] = Integer.MAX_VALUE;
			for (int i = 0; i < n / 2; i++)
				rahulArr[i] = scan.nextInt();
			rahulArr[n - first] = Integer.MAX_VALUE;
			merge(arr, tinaArr, rahulArr);
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static void merge(int[] arr, int[] a1, int[] a2) {
		int i1 = 0, i2 = 0, index = 0;
		while (index != arr.length) {
			if (a1[i1] <= a2[i2])
				arr[index] = a1[i1++];
			else
				arr[index] = a2[i2++];
			index++;
		}
	}

}
