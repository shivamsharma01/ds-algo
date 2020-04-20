package prepbytes.topic.array;

import java.util.Scanner;

public class InterestingArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		while (testCases > 0) {
			int n = scan.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
			}
			int k = scan.nextInt();
			int maxIndex = returnMaxIndex(a, k);
			System.out.println(getPair(a, k, maxIndex));
			--testCases;
		}
	}

	private static Integer returnMaxIndex(int[] a, int value) {
		int start = 0;
		int end = a.length - 1;
		int middle = (start + end) / 2;
		Integer index = null;
		while (start < end) {
			if (a[middle] == value) {
				return middle;
			}
			if (value < a[middle]) {
				end = middle - 1;
				middle = (start + end) / 2;
			} else {
				start = middle + 1;
				middle = (start + end) / 2;
			}
		}
		return a.length - 1;
	}

	private static String getPair(int[] a, int value, int index) {
		String output = "no answer";
		for (int i = index; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (a[i] + a[j] == value) {
					return j + " " + i;
				} else if (a[i] + a[j] > value) {
					break;
				}
			}
		}
		return output;
	}
}
