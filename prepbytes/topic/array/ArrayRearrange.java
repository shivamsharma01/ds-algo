package prepbytes.topic.array;

import java.util.Scanner;

public class ArrayRearrange {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = scan.nextInt();
			int[] a = new int[n];
			for (int j = 0; j < n / 2; j++) {
				a[2 * j + 1] = scan.nextInt();
			}
			for (int j = n / 2; j < n; j++) {
				a[2 * (n - (j + 1))] = scan.nextInt();
			}
			for (int j = 0; j < n; j++) {
				System.out.print(j < n - 1 ? a[j] + " " : a[j] + "\n");
			}
		}
	}
}
