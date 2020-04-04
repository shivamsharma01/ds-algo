package prepbytes.array;

import java.util.*;
import java.io.*;

public class FindMaxIJ {
	public static void main(String args[]) throws IOException {

		// write your code here
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int[] min = new int[n];
		int[] max = new int[n];

		arr[0] = scan.nextInt();
		min[0] = arr[0];
		for (int i = 1; i < n; i++) {
			arr[i] = scan.nextInt();
			if (min[i - 1] < arr[i]) {
				min[i] = min[i - 1];
			} else {
				min[i] = arr[i];
			}
		}
		max[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (max[i + 1] > arr[i]) {
				max[i] = max[i + 1];
			} else {
				max[i] = arr[i];
			}
		}
		int maxDif = -1;
		int i = 0, j = 0;
		while (i != n && j != n) {
			if (min[i] < max[j]) {
				if (maxDif < (j - i)) {
					maxDif = (j - i);
				}
				j++;
			} else {
				i++;
			}
		}
		System.out.println(maxDif);
	}
}