package geeksforgeeks.divideNconquer;

import java.util.Scanner;

public class MedianOfSortedArraysOfSameSize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr1 = new int[n], arr2 = new int[n];
			for (int i = 0; i < n; i++)
				arr1[i] = sc.nextInt();
			for (int i = 0; i < n; i++)
				arr2[i] = sc.nextInt();
			if (n == 0)
				System.out.println("Array is empty");
			if (n == 1)
				System.out.println((arr1[0] + arr2[0]) / (double) 2);
			else
				System.out.println(findMedian(arr1, arr2, 0, 0, n - 1, n - 1));
		}
	}

	private static float findMedian(int[] A, int[] B, int startA, int startB, int endA, int endB) {
		if (endA - startA == 1)
			return (Math.max(A[startA], B[startB]) + Math.min(A[endA], B[endB])) / 2;
		float median1 = median(A, startA, endA), median2 = median(B, startB, endB);
		if (median1 == median2)
			return median1;
		else if (median1 > median2)
			return findMedian(A, B, startA, (startB + endB + 1) / 2, (startA + endA + 1) / 2, endB);
		else
			return findMedian(A, B, (startA + endA + 1) / 2, startB, endA, (startB + endB + 1) / 2);
	}

	private static float median(int[] arr, int start, int end) {
		int n = end - start + 1;
		if (n % 2 == 1)
			return arr[start + n / 2];
		else
			return (arr[start + n / 2] + arr[start + n / 2 - 1]) / (float) 2;
	}
}
