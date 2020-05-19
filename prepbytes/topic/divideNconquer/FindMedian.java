package prepbytes.topic.divideNconquer;

import java.util.Scanner;

public class FindMedian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int n = sc.nextInt(), m = sc.nextInt();
			int[] arr1 = new int[n], arr2 = new int[m];
			for (int i = 0; i < n; i++)
				arr1[i] = sc.nextInt();
			for (int i = 0; i < m; i++)
				arr2[i] = sc.nextInt();
			double ans = medianUsingPartitioning(arr1, arr2);
			if (ans % 1 == 0)
				System.out.println((int) ans);
			else
				System.out.println(ans);
		}
	}

	/*
	 * Complexity = O(log(min(A,B)))
	 */
	public static double medianUsingPartitioning(int[] A, int[] B) {
		if (A.length > B.length)
			return medianUsingPartitioning(B, A);
		int x = A.length, y = B.length, low = 0, high = x, partitionX, partitionY, maxLeftX, minRightX, maxLeftY,
				minRightY;
		while (low <= high) {
			partitionX = (low + high) / 2;
			partitionY = (x + y + 1) / 2 - partitionX;
			maxLeftX = partitionX > 0 ? A[partitionX - 1] : Integer.MIN_VALUE;
			minRightX = partitionX < x ? A[partitionX] : Integer.MAX_VALUE;
			maxLeftY = partitionY > 0 ? B[partitionY - 1] : Integer.MIN_VALUE;
			minRightY = partitionY < y ? B[partitionY] : Integer.MAX_VALUE;
			if (maxLeftX <= minRightY && minRightX >= maxLeftY)
				if ((x + y) % 2 == 0)
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				else
					return Math.max(maxLeftX, maxLeftY);
			else if (maxLeftX > minRightY)
				high = partitionX - 1;
			else
				low = partitionX + 1;
		}
		return 0;
	}

	/*
	 * Complexity = O(m+n)
	 */
	public static double medianUsingMergeSort(int[] A, int[] B) {
		int[] t = new int[A.length + B.length];
		int i1 = 0, i2 = 0, i;
		for (i = 0; i < (A.length + B.length) && i1 < A.length && i2 < B.length; i++) {
			if (A[i1] < B[i2])
				t[i] = A[i1++];
			else
				t[i] = B[i2++];
		}
		while (i1 < A.length)
			t[i++] = A[i1++];
		while (i2 < B.length)
			t[i++] = B[i2++];
		if ((i1 + i2) % 2 == 1)
			return t[(i1 + i2) / 2];
		else
			return (double) (t[(i1 + i2) / 2 - 1] + t[(i1 + i2) / 2]) / 2;
	}

}
