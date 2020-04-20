package prepbytes.topic.array;

import java.util.Scanner;

public class ArrayMax {

	public static void main(String args[]) {

		// write your code here
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int test = 0; test < testCases; test++) {
			int n = scan.nextInt();
			int max = 0;
			int[] a = new int[n];
			int k = scan.nextInt();
			for (int i = 0; i < k; i++) {
				a[i] = scan.nextInt();
				if (a[i] > max) {
					max = a[i];
				}
			}
			for (int i = k; i < n; i++) {
				a[i] = scan.nextInt();
				if (a[i - k] > 0) {
					a[i] += a[i - k];
				}
				if (a[i] > max) {
					max = a[i];
				}
			}
			System.out.println(max);
		}
	}
}
