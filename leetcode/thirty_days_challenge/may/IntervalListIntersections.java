package leetcode.thirty_days_challenge.may;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public static void main(String[] args) {
		IntervalListIntersections o = new IntervalListIntersections();
		int[][] output = o.intervalIntersection(new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
				new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } });
		System.out.print("[");
		for (int[] a : output)
			System.out.print("[" + a[0] + "," + a[1] + "]" + " ");
		System.out.print("]");
	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		if (A.length == 0 || B.length == 0) {
			return new int[][] {};
		}
		List<int[]> result = new ArrayList<>();
		int i = 0, j = 0, M = A.length, N = B.length, low, high;
		while ((i < M) && (j < N)) {
			low = Math.max(A[i][0], B[j][0]);
			high = Math.min(A[i][1], B[j][1]);
			if (low <= high)
				result.add(new int[] { low, high });
			if (A[i][1] < B[j][1])
				i++;
			else
				j++;
		}
		return result.toArray(new int[result.size()][]);
	}

}