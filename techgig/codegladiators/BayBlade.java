package techgig.codegladiators;

import java.util.Scanner;

public class BayBlade {

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			long[] teamGRevolution = new long[scan.nextInt()];
			long[] opponents = new long[teamGRevolution.length];
			for (int i = 0; i < teamGRevolution.length; i++) {
				teamGRevolution[i] = scan.nextLong();
			}
			for (int i = 0; i < opponents.length; i++) {
				opponents[i] = scan.nextLong();
			}
			mergeSort(teamGRevolution, 0, teamGRevolution.length - 1);
			mergeSort(opponents, 0, opponents.length - 1);
			int left = 0;
			int opponentIndex = 0;
			int wins = 0;
			int count = 0;
			while (count < opponents.length) {
				if (teamGRevolution[left] > opponents[opponentIndex]) {
					wins++;
					left++;
					opponentIndex++;
				} else
					left++;
				count++;
			}
			System.out.println(wins);
		}
	}

	private static void mergeSort(long[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	private static void merge(long[] arr, int left, int middle, int right) {
		long[] t1 = new long[middle - left + 2];
		long[] t2 = new long[right - middle + 1];
		for (int i = 0; i <= middle - left; i++)
			t1[i] = arr[left + i];
		for (int i = 0; i < right - middle; i++)
			t2[i] = arr[middle + i + 1];
		t1[t1.length - 1] = Long.MAX_VALUE;
		t2[t2.length - 1] = Long.MAX_VALUE;
		int i1 = 0, i2 = 0;
		for (int i = left; i <= right; i++) {
			if (t1[i1] < t2[i2])
				arr[i] = t1[i1++];
			else
				arr[i] = t2[i2++];
		}
	}
}
