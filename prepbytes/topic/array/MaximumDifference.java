package prepbytes.topic.array;

import java.io.IOException;
import java.util.Scanner;

public class MaximumDifference {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++) {
			int[] a = new int[scan.nextInt()];
			int max = Integer.MIN_VALUE;
			int indexIfSmallerAhead = 0;
			int indexIfGreaterAhead = 0;
			a[0] = scan.nextInt();
			Integer currentDifference, currentMax = null;
			for (int j = 1; j < a.length; j++) {
				a[j] = scan.nextInt();
				currentDifference = a[j] - a[indexIfSmallerAhead];
				currentMax = Math.abs(currentDifference) + j - indexIfSmallerAhead;
				if (currentMax > max) {
					max = currentMax;
				}
				if (currentDifference > j - indexIfSmallerAhead) {
					indexIfSmallerAhead = j;
				}
				currentDifference = a[indexIfGreaterAhead] - a[j];
				currentMax = Math.abs(currentDifference) + j - indexIfGreaterAhead;
				if (currentMax > max) {
					max = currentMax;
				}
				if (currentDifference > j - indexIfGreaterAhead) {
					indexIfGreaterAhead = j;
				}
			}
			System.out.println(max);
		}
	}

}